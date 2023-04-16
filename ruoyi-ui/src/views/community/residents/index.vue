<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="68px" size="small">
      <!--                  <el-form-item label="用户id" prop="userId">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.userId"-->
      <!--                        placeholder="请输入用户id"-->
      <!--                        clearable-->
      <!--                        @keyup.enter.native="handleQuery"-->
      <!--                    />-->
      <!--                  </el-form-item>-->
      <el-form-item label="单元号" prop="unitNumber">
        <el-input
          v-model="queryParams.unitNumber"
          clearable
          placeholder="请输入单元号"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼号" prop="buildingNumber">
        <el-input
          v-model="queryParams.buildingNumber"
          clearable
          placeholder="请输入楼号"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="房屋面积" prop="area">
        <el-input
          v-model="queryParams.area"
          clearable
          placeholder="请输入房屋面积"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--                  <el-form-item label="居住地址" prop="address">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.address"-->
      <!--                        placeholder="请输入居住地址"-->
      <!--                        clearable-->
      <!--                        @keyup.enter.native="handleQuery"-->
      <!--                    />-->
      <!--                  </el-form-item>-->
      <!--                  <el-form-item label="备注" prop="remarks">-->
      <!--                    <el-input-->
      <!--                        v-model="queryParams.remarks"-->
      <!--                        placeholder="请输入备注"-->
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
          v-hasPermi="['community:residents:add']"
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
          v-hasPermi="['community:residents:edit']"
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
          v-hasPermi="['community:residents:remove']"
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
          v-hasPermi="['community:residents:export']"
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

    <el-table v-loading="loading" :data="residentsList" @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="55"/>
<!--      <el-table-column align="center" label="住户id" prop="residentsId"/>-->
      <el-table-column align="center" label="用户名" prop="sysUser.userName"/>
      <el-table-column align="center" label="单元号" prop="unitNumber"/>
      <el-table-column align="center" label="楼号" prop="buildingNumber"/>
      <el-table-column align="center" label="房屋面积" prop="area"/>
      <el-table-column align="center" label="居住地址" prop="address"/>
      <el-table-column align="center" label="备注" prop="remarks"/>
      <!--              <el-table-column label="0正常1停用" align="center" prop="status" />-->
      <!--              <el-table-column label="${comment}" align="center" prop="remark" />-->
      <el-table-column align="center" class-name="small-padding fixed-width" label="操作">
        <template slot-scope="scope">
          <el-button
            v-hasPermi="['community:residents:edit']"
            icon="el-icon-edit"
            size="mini"
            type="text"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            v-hasPermi="['community:residents:remove']"
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

    <!-- 添加或修改住户信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" append-to-body width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id"/>
        </el-form-item>
        <el-form-item label="单元号" prop="unitNumber">
          <el-input v-model="form.unitNumber" placeholder="请输入单元号"/>
        </el-form-item>
        <el-form-item label="楼号" prop="buildingNumber">
          <el-input v-model="form.buildingNumber" placeholder="请输入楼号"/>
        </el-form-item>
        <el-form-item label="房屋面积" prop="area">
          <el-input v-model="form.area" placeholder="请输入房屋面积"/>
        </el-form-item>
        <el-form-item label="居住地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入居住地址"/>
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注"/>
        </el-form-item>
        <!--        <el-form-item label="0表示存在2表示删除" prop="delFlag">-->
        <!--          <el-input v-model="form.delFlag" placeholder="请输入0表示存在2表示删除"/>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="${comment}" prop="remark">-->
        <!--          <el-input v-model="form.remark" placeholder="请输入${comment}"/>-->
        <!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addResidents, delResidents, getResidents, listResidents, updateResidents} from '@/api/community/residents'

export default {
  name: 'Residents',
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
      // 住户信息表格数据
      residentsList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        buildingNumber: null,
        unitNumber: null,
        area: null,
        address: null,
        remarks: null,
        status: null,
        sysUser: null
      },
      // 表单参数
      form: {},
      // 表单校验
      defaultProps: {
        children: "children",
        label: "label"
      },
      rules: {
        userId: [
          {required: true, message: '用户id不能为空', trigger: 'blur'}
        ],
        buildingNumber: [
          {required: true, message: '楼号不能为空', trigger: 'blur'}
        ],
        unitNumber: [
          {required: true, message: '单元号不能为空', trigger: 'blur'}
        ],
        area: [
          {required: true, message: '房屋面积不能为空', trigger: 'blur'}
        ],
        address: [
          {required: true, message: '居住地址不能为空', trigger: 'blur'}
        ]
        // remarks: [
        //   {required: true, message: "备注不能为空", trigger: "blur"}
        // ],
        //       status: [
        //   { required: true, message: "0正常1停用不能为空", trigger: "change" }
        // ],
        //       delFlag: [
        //   { required: true, message: "0表示存在2表示删除不能为空", trigger: "blur" }
        // ],
        //       createBy: [
        //   { required: true, message: "创建者不能为空", trigger: "blur" }
        // ],
        //       createTime: [
        //   { required: true, message: "创建时间不能为空", trigger: "blur" }
        // ],
        //       updateBy: [
        //   { required: true, message: "更新时间不能为空", trigger: "blur" }
        // ],
        //       updateTime: [
        //   { required: true, message: "更新者不能为空", trigger: "blur" }
        // ],
        //       remark: [
        //   { required: true, message: "$comment不能为空", trigger: "blur" }
        // ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询住户信息列表 */
    getList() {
      this.loading = true
      listResidents(this.queryParams).then(response => {
        this.residentsList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        residentsId: null,
        userId: null,
        buildingNumber: null,
        unitNumber: null,
        area: null,
        address: null,
        remarks: null,
        status: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.residentsId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加住户信息'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const residentsId = row.residentsId || this.ids
      getResidents(residentsId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改住户信息'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.residentsId != null) {
            updateResidents(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addResidents(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const residentsIds = row.residentsId || this.ids
      this.$modal.confirm('是否确认删除住户信息编号为"' + residentsIds + '"的数据项？').then(function () {
        return delResidents(residentsIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('community/residents/export', {
        ...this.queryParams
      }, `residents_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
