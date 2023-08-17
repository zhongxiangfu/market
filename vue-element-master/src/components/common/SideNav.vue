<template>
    <el-menu default-active="/testManagement" class="el-menu-vertical-demo" router>
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-message"></i>预定管理</template>
      <el-menu-item-group>
        <el-menu-item index="/index/testManagement">我的预定</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
