<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
}
</style>
<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { useRouter } from "vue-router";
import store from "@/store";

const router = useRouter();
router.beforeEach((to, from, next) => {
  // 仅管理员可见，【判断当前用户是否为管理员
  if (to.meta?.access === "canAdmin") {
    if (store.state.user?.loginUser?.role !== "admin") {
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
