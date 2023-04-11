<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="68px" size="small">
      <el-form-item label="车位ID" prop="parkingSpaceId">
        <el-input
          v-model="queryParams.parkingSpaceId"
          clearable
          placeholder="请输入车位ID"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          clearable
          placeholder="请输入用户id"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车位号" prop="parkingSpaceNumber">
        <el-input
          v-model="queryParams.parkingSpaceNumber"
          clearable
          placeholder="请输入车位号"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否停用" prop="status">
        <el-select v-model="queryParams.status" clearable placeholder="请选择是否停用">
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否租用" prop="rent">
        <el-input
          v-model="queryParams.rent"
          clearable
          placeholder="请输入是否租用"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-search" size="mini" type="primary" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['community:spaces:add']"
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
          v-hasPermi="['community:spaces:edit']"
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
          v-hasPermi="['community:spaces:remove']"
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
          v-hasPermi="['community:spaces:export']"
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

    <el-table v-loading="loading" :data="spacesList" @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="55"/>
      <el-table-column align="center" label="主键" prop="parkId"/>
      <el-table-column align="center" label="车位ID" prop="parkingSpaceId"/>
      <el-table-column align="center" label="用户id" prop="userId"/>
      <el-table-column align="center" label="车位号" prop="parkingSpaceNumber"/>
      <el-table-column align="center" label="是否停用" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column align="center" label="是否租用" prop="rent">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.rent"/>
        </template>
      </el-table-column>
      <el-table-column align="center" label="备注" prop="remark"/>
      <el-table-column align="center" class-name="small-padding fixed-width" label="操作">
        <template slot-scope="scope">
          <el-button
            v-hasPermi="['community:spaces:edit']"
            icon="el-icon-edit"
            size="mini"
            type="text"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            v-hasPermi="['community:spaces:remove']"
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

    <!-- 添加或修改车位信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" append-to-body width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车位ID" prop="parkingSpaceId">
          <el-input v-model="form.parkingSpaceId" placeholder="请输入车位ID"/>
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id"/>
        </el-form-item>
        <el-form-item label="车位号" prop="parkingSpaceNumber">
          <el-input v-model="form.parkingSpaceNumber" placeholder="请输入车位号"/>
        </el-form-item>
        <el-form-item label="是否停用" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否租用" prop="rent">
          <el-input v-model="form.rent" placeholder="请输入是否租用"/>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addSpaces, delSpaces, getSpaces, listSpaces, updateSpaces} from "@/api/community/spaces";

export default {
  name: "Spaces",
  dicts: ['sys_normal_disable'],
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
      // 车位信息表格数据
      spacesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        parkingSpaceId: null,
        userId: null,
        parkingSpaceNumber: null,
        status: null,
        rent: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        parkingSpaceId: [
          {required: true, message: "车位ID不能为空", trigger: "blur"}
        ],
        userId: [
          {required: true, message: "用户id不能为空", trigger: "blur"}
        ],
        status: [
          {required: true, message: "是否停用不能为空", trigger: "change"}
        ],
        rent: [
          {required: true, message: "是否租用不能为空", trigger: "blur"}
        ],
        createBy: [
          {required: true, message: "创建者不能为空", trigger: "blur"}
        ],
        createTime: [
          {required: true, message: "创建时间不能为空", trigger: "blur"}
        ],
        updateBy: [
          {required: true, message: "更新时间不能为空", trigger: "blur"}
        ],
        updateTime: [
          {required: true, message: "更新者不能为空", trigger: "blur"}
        ],
        remark: [
          {required: true, message: "备注不能为空", trigger: "blur"}
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询车位信息列表 */
    getList() {
      this.loading = true;
      listSpaces(this.queryParams).then(response => {
        this.spacesList = response.rows;
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
        parkId: null,
        parkingSpaceId: null,
        userId: null,
        parkingSpaceNumber: null,
        status: null,
        rent: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.parkId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车位信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const parkId = row.parkId || this.ids
      getSpaces(parkId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车位信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.parkId != null) {
            updateSpaces(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSpaces(this.form).then(response => {
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
      const parkIds = row.parkId || this.ids;
      this.$modal.confirm('是否确认删除车位信息编号为"' + parkIds + '"的数据项？').then(function () {
        return delSpaces(parkIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('community/spaces/export', {
        ...this.queryParams
      }, `spaces_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
