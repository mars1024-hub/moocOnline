<template>
  <div style="margin-top: 20px">

    <el-form :model="params">
      <span style="margin-left: 10px"></span>
      站点：
      <el-select v-model="params.siteId" placeholder="请选择站点" size="small">
        <el-option
          v-for="item in siteList"
          :key="item.siteId"
          :label="item.siteName"
          :value="item.siteId">
        </el-option>
      </el-select>
      <span style="margin-left: 10px"></span>
      页面别名:
      <el-input v-model="params.pageAliase" style="width: 100px" size="small" label-width="20px"></el-input>
      <el-button type="primary" size="small" icon="el-icon-search" v-on:click="query" style="margin-left: 10px;">查询
      </el-button>
      <router-link
        :to="{path:'/cms/page/add/',query:{page:this.params.page,size:this.params.size,siteId:this.params.siteId,pageAliase:this.params.pageAliase}}">
        <el-button type="primary" size="small" icon="el-icon-circle-plus-outline" style="float: right">新增页面</el-button>
      </router-link>
    </el-form>
    <el-table
          :data="tableData"
          stripe
          style="width: 100%" v-loading="loading">
      <el-table-column type="index"  width="50" label="序号">
      </el-table-column>
      <el-table-column prop="pageName"  label="页面名称"  width="320">
      </el-table-column>
      <el-table-column prop="pageAliase"  label="别名"  width="120">
      </el-table-column>
      <el-table-column prop="pageType"  label="页面类型"  width="80">
      </el-table-column>
      <el-table-column prop="pageWebPath"  label="访问路径"  width="250">
      </el-table-column>
      <el-table-column prop="pagePhysicalPath"  label="物理路径"  width="500">
      </el-table-column>
      <el-table-column prop="pageCreateTime"  label="创建时间"  width="300"  >    
      </el-table-column>
       
    </el-table>
    <!--分页-->
    <el-pagination
      background
      layout="total,sizes,prev, pager, next"
      :page-size="this.params.size"
      :current-page="this.params.page"
      :total="total"
      v-on:current-change="changePage"
      @size-change="handleSizeChange"
      style="float:right;margin-top: 10px">

    </el-pagination>
  </div>


</template>

<script>
  import * as cmsApi from '../api/cms'

  export default {
    data() {
      return {
        total: 0,
        siteList: [],//站点列表
        params: {
          page: 1,
          size: 10,
          siteId: '',
          pageAliase: ''
        },
        tableData: [],
        loading: true
      }

    },
    mounted() {
      this.query();
      cmsApi.site_list().then((res) => {
        this.siteList = res.queryResult.list;
      })
    },
    created() {
      this.params.page = Number.parseInt(this.$route.query.page || 1);
      this.params.size = Number.parseInt(this.$route.query.size || 10);
      this.params.siteId = this.$route.query.siteId || '';
      this.params.pageAliase = this.$route.query.pageAliase || '';
    },
    methods: {
      //分页查询
      changePage: function (page) {
        this.params.page = page;
        this.query();
      },
      handleSizeChange(size) {
        this.params.size = size;
        this.query();
      },
      query: function () {
        cmsApi.page_list(this.params.page, this.params.size, this.params).then((res) => {
          this.tableData = res.queryResult.list;
          this.total = res.queryResult.total;
          // let item = {};
          // for (let i = 0; i < res.queryResult.list.length; i++) {
          //   item = res.queryResult.list[i];
          //   if (this.siteList.length === 0) {
          //     this.siteList.push(item);
          //   } else {
          //     for (let j = 0; j < this.siteList.length; j++) {
          //       if (this.siteList[j].siteName !== item.siteName) {
          //         this.siteList.push(item);
          //       }
          //     }
          //   }
          // }
          this.loading = false;
        })
      }
    }
  }
</script>
