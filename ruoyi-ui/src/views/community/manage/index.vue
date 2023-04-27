<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="68px" size="small">
      <el-form-item label="设备名称" prop="deviceName">
        <el-input
          v-model="queryParams.deviceName"
          clearable
          placeholder="请输入设备名称"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--                  <el-form-item label="设备编号" prop="deviceNo">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.deviceNo"-->
      <!--                        placeholder="请输入设备编号"-->
      <!--                        clearable-->
      <!--                        @keyup.enter.native="handleQuery"-->
      <!--                    />-->
      <!--                  </el-form-item>-->
      <el-form-item label="设备类型" prop="deviceType">
        <el-select v-model="queryParams.deviceType" clearable placeholder="请选择设备类型">
          <el-option
            v-for="dict in dict.type.device_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="设备状态" prop="deviceState">
        <el-select v-model="queryParams.deviceState" clearable placeholder="请选择设备状态">
          <el-option
            v-for="dict in dict.type.sys_common_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!--                  <el-form-item label="设备位置" prop="deviceLocation">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.deviceLocation"-->
      <!--                        placeholder="请输入设备位置"-->
      <!--                        clearable-->
      <!--                        @keyup.enter.native="handleQuery"-->
      <!--                    />-->
      <!--                  </el-form-item>-->
      <el-form-item label="责任人" prop="deviceUser">
        <el-input
          v-model="queryParams.deviceUser"
          clearable
          placeholder="请输入设备责任人"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--                  <el-form-item label="设备购买时间" prop="deviceBuyTime">-->
      <!--                    <el-date-picker clearable-->
      <!--                                    v-model="queryParams.deviceBuyTime"-->
      <!--                                    type="date"-->
      <!--                                    value-format="yyyy-MM-dd"-->
      <!--                                    placeholder="请选择设备购买时间">-->
      <!--                    </el-date-picker>-->
      <!--                  </el-form-item>-->
      <!--                  <el-form-item label="设备保修期限" prop="deviceWarrantyPeriod">-->
      <!--                    <el-date-picker clearable-->
      <!--                                    v-model="queryParams.deviceWarrantyPeriod"-->
      <!--                                    type="date"-->
      <!--                                    value-format="yyyy-MM-dd"-->
      <!--                                    placeholder="请选择设备保修期限">-->
      <!--                    </el-date-picker>-->
      <!--                  </el-form-item>-->
      <!--                  <el-form-item label="设备使用说明书" prop="deviceUseDesc">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.deviceUseDesc"-->
      <!--                        placeholder="请输入设备使用说明书"-->
      <!--                        clearable-->
      <!--                        @keyup.enter.native="handleQuery"-->
      <!--                    />-->
      <!--                  </el-form-item>-->
      <el-form-item>
        <el-button icon="el-icon-search" size="mini" type="primary" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['community:manage:add']"
          icon="el-icon-plus"
          plain
          size="mini"
          type="primary"
          @click="handleAdd"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['community:manage:edit']"
          :disabled="single"
          icon="el-icon-edit"
          plain
          size="mini"
          type="success"
          @click="handleUpdate"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['community:manage:remove']"
          :disabled="multiple"
          icon="el-icon-delete"
          plain
          size="mini"
          type="danger"
          @click="handleDelete"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['community:manage:export']"
          icon="el-icon-download"
          plain
          size="mini"
          type="warning"
          @click="handleExport"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="manageList" @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="55"/>
      <!--              <el-table-column label="设备id" align="center" prop="deviceId"/>-->
      <el-table-column align="center" label="设备名称" prop="deviceName"/>
      <el-table-column align="center" label="设备编号" prop="deviceNo"/>
      <el-table-column align="center" label="设备类型" prop="deviceType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.device_type" :value="scope.row.deviceType"/>
        </template>
      </el-table-column>
      <el-table-column align="center" label="设备状态" prop="deviceState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_status" :value="scope.row.deviceState"/>
        </template>
      </el-table-column>
      <el-table-column align="center" label="设备位置" prop="deviceLocation"/>
      <el-table-column align="center" label="责任人" prop="deviceUser"/>
      <el-table-column align="center" label="购买时间" prop="deviceBuyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deviceBuyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="保修期限" prop="deviceWarrantyPeriod" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deviceWarrantyPeriod, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="维护记录" prop="deviceMaintainRecords"/>
      <el-table-column align="center" label="使用说明书" prop="deviceUseDesc"/>
      <el-table-column align="center" class-name="small-padding fixed-width" label="操作">
        <template slot-scope="scope">
          <el-button
            v-hasPermi="['community:manage:edit']"
            icon="el-icon-edit"
            size="mini"
            type="text"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            v-hasPermi="['community:manage:remove']"
            icon="el-icon-delete"
            size="mini"
            type="text"
            @click="handleDelete(scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :limit.sync="queryParams.pageSize"
      :page.sync="queryParams.pageNum"
      :total="total"
      @pagination="getList"
    />

    <!-- 添加或修改设备管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" append-to-body width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备名称" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名称"/>
        </el-form-item>
        <el-form-item label="设备编号" prop="deviceNo">
          <el-input v-model="form.deviceNo" placeholder="请输入设备编号"/>
        </el-form-item>
        <el-form-item label="设备类型" prop="deviceType">
          <el-select v-model="form.deviceType" placeholder="请选择设备类型">
            <el-option
              v-for="dict in dict.type.device_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设备状态" prop="deviceState">
          <el-select v-model="form.deviceState" placeholder="请选择设备状态">
            <el-option
              v-for="dict in dict.type.sys_common_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设备位置" prop="deviceLocation">
          <el-input v-model="form.deviceLocation" placeholder="请输入设备位置"/>
        </el-form-item>
        <el-form-item label="设备责任人" prop="deviceUser">
          <el-input v-model="form.deviceUser" placeholder="请输入设备责任人"/>
        </el-form-item>
        <el-form-item label="设备购买时间" prop="deviceBuyTime">
          <el-date-picker v-model="form.deviceBuyTime"
                          clearable
                          placeholder="请选择设备购买时间"
                          type="date"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="设备保修期限" prop="deviceWarrantyPeriod">
          <el-date-picker v-model="form.deviceWarrantyPeriod"
                          clearable
                          placeholder="请选择设备保修期限"
                          type="date"
                          value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="设备维护记录" prop="deviceMaintainRecords">
          <el-input v-model="form.deviceMaintainRecords" placeholder="请输入内容" type="textarea"/>
        </el-form-item>
        <el-form-item label="设备使用说明书" prop="deviceUseDesc">
          <el-input v-model="form.deviceUseDesc" placeholder="请输入设备使用说明书"/>
        </el-form-item>
        <!--                        <el-form-item label="删除标志" prop="delFlag">-->
        <!--                          <el-input v-model="form.delFlag" placeholder="请输入删除标志"/>-->
        <!--                        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addManage, delManage, getManage, listManage, updateManage} from "@/api/community/manage";

export default {
  name: "Manage",
  dicts: ['sys_common_status', 'device_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 设备管理表格数据
      manageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deviceName: null,
        deviceNo: null,
        deviceType: null,
        deviceState: null,
        deviceLocation: null,
        deviceUser: null,
        deviceBuyTime: null,
        deviceWarrantyPeriod: null,
        deviceMaintainRecords: null,
        deviceUseDesc: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deviceType: [
          {required: true, message: "设备类型不能为空", trigger: "change"}
        ],
        //       deviceMaintainRecords: [
        //   { required: true, message: "设备维护记录不能为空", trigger: "blur" }
        // ],
        //       deviceUseDesc: [
        //   { required: true, message: "设备使用说明书不能为空", trigger: "blur" }
        // ],
        //       delFlag: [
        //   { required: true, message: "删除标志不能为空", trigger: "blur" }
        // ],
        //       createBy: [
        //   { required: true, message: "创建者不能为空", trigger: "blur" }
        // ],
        //       createTime: [
        //   { required: true, message: "创建时间不能为空", trigger: "blur" }
        // ],
        //       updateBy: [
        //   { required: true, message: "更新者不能为空", trigger: "blur" }
        // ],
        //       updateTime: [
        //   { required: true, message: "更新时间不能为空", trigger: "blur" }
        // ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备管理列表 */
    getList() {
      this.loading = true;
      listManage(this.queryParams).then(response => {
        this.manageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        deviceId: null,
        deviceName: null,
        deviceNo: null,
        deviceType: null,
        deviceState: null,
        deviceLocation: null,
        deviceUser: null,
        deviceBuyTime: null,
        deviceWarrantyPeriod: null,
        deviceMaintainRecords: null,
        deviceUseDesc: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.deviceId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加设备管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const deviceId = row.deviceId || this.ids
      getManage(deviceId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.deviceId != null) {
            updateManage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManage(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const deviceIds = row.deviceId || this.ids;
      this.$modal.confirm('是否确认删除设备管理编号为"' + deviceIds + '"的数据项？').then(function () {
        return delManage(deviceIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('community/manage/export', {
        ...this.queryParams
      }, `manage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
