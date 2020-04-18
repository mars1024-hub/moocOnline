<template>
  <div style="margin-top: 20px">
    <el-form ref="pageForm" :model="pageForm" :rules="pageFormRules" label-width="80px">
      <el-form-item label="所属站点" prop="siteId">
        <el-select v-model="pageForm.siteId" placeholder="请选择站点">
          <el-option v-for="item in siteList" :key="item.siteId" :label="item.siteName" :value="item.siteId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="选择模板" prop="templateId">
        <el-select v-model="pageForm.templateId" placeholder="请选择模板">
          <el-option v-for="item in templateList" :key="item.templateId" :label="item.templateName"
                     :value="item.templateId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="页面名称" prop="pageName">
        <el-input v-model="pageForm.pageName" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="别名" prop="pageAliase">
        <el-input v-model="pageForm.pageAliase" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="访问路径"  prop="pageWebPath">
        <el-input v-model="pageForm.pageWebPath"  auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="物理路径"  prop="pagePhysicalPath">
        <el-input v-model="pageForm.pagePhysicalPath"  auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="类型">
        <el-radio-group v-model="pageForm.pageType">
          <el-radio class="radio"  label="0">静态</el-radio>
          <el-radio class="radio"  label="1">动态</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker type="datetime"  placeholder="创建时间"  v-model="pageForm.pageCreateTime">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="go_back">返回</el-button>
        <el-button type="primary" @click="addSubmit">提交</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>
<script>
  import * as cmsApi from '../api/cms'

  export default {

    data() {
      return {
        //站点列表
        siteList: [],
        //模版列表
        templateList: [],
        //新增界面数据
        pageForm: {
          siteId: '',
          templateId: '',
          pageName: '',
          pageAliase: '',
          pageWebPath: '',
          pageParameter: '',
          pagePhysicalPath: '',
          pageType: '0',
          pageCreateTime: new Date()
        },
        pageFormRules: {
          siteId: [{required: true, message: '请选择站点', trigger: 'blur'}],
          templateId: [{required: true, message: '请选择模板', trigger: 'blur'}],
          pageName: [{required: true, message: '请选择页面名称', trigger: 'blur'}],
          pageWebPath: [{required: true, message: '请选择访问路径', trigger: 'blur'}],
          pagePhysicalPath: [{required: true, message: '请选择物理路径', trigger: 'blur'}],
          pageAliase: [{required: true, message: '请输入别名', trigger: 'blur'}]
        }
      }
    },
    created() {
      //查询站点列表
      cmsApi.site_list().then((res)=>{
        this.siteList = res.queryResult.list;
      })
      //查询模板列表
      cmsApi.template_list().then((res)=>{
        this.templateList = res.queryResult.list;

      })
    },
    methods: {
      addSubmit() {
        this.$refs.pageForm.validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              cmsApi.page_add(this.pageForm).then((res) => {
                console.log(res);
                if (res.success) {
                  this.go_back();
                  this.$message({
                    message: '提交成功',
                    type: 'success'
                  })
                  this.$refs['pageForm'].resetFields();
                } else {
                  this.$message.error('提交失败');
                }
              })
            })

          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      go_back() {
        this.$router.push({
          path: '/cms/page/list',
          query: {
            page: this.$route.query.page,
            size: this.$route.query.size,
            siteId: this.$route.query.siteId,
            pageAliase: this.$route.query.pageAliase
          }
        })
      }
    }
  }
</script>
<style>

</style>
