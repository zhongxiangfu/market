<template>
  <div id="testManagement">
    <el-tabs :active-name="activeName">
      <el-tab-pane label="预定列表" name="first">
        <test-project></test-project>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import TestProject from './TestProject.vue';
  export default{
    data(){
      return {
          activeName: 'first'
      }
    },
    components:{
      TestProject,
    }
  }
</script>

<style>
  .el-tabs{
    width: 100%;
  }
</style>
