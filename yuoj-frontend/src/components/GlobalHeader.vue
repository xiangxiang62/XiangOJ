<script setup lang="ts">
import { routes } from "@/router/routes";
import { useRouter } from "vue-router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/access/checkAccess";
import ACCESS_ENUM from "@/access/accessEnum";

const router = useRouter();
const store = useStore();
const loginUser = store.state.user.loginUser;
// 展示在菜单的路由
const visibleRoutes = computed(() => {
  return routes.filter((item, index) => {
    if (item.meta?.hideInMenu) {
      return false;
    }
    // todo 根据权限控制菜单显示隐藏
    if (!checkAccess(store.state.user.loginUser, item.meta?.access as string)) {
      return false;
    }
    return true;
  });
});
const doMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};

console.log(store.state.user.loginUser);

setTimeout(() => {
  store.dispatch("user/getLoginUser", {
    userName: "香香管理员",
    userRole: ACCESS_ENUM.ADMIN,
  });
}, 3000);

// 默认主页
const selectedKeys = ref(["/"]);

// 路由跳转时，更新选中的菜单项
router.afterEach((to, from, failure) => {
  selectedKeys.value = [to.path];
});
</script>

<template>
  <a-row id="globalHeader" align="center" :wrap="false">
    <a-col flex="auto">
      <a-menu
        mode="horizontal"
        :selectedKeys="selectedKeys"
        @menu-item-click="doMenuClick"
      >
        <a-menu-item
          key="0"
          :style="{ padding: 0, marginRight: '38px' }"
          disabled
        >
          <div class="title-bar">
            <img
              class="logo"
              src="https://img0.baidu.com/it/u=1249277386,3219917190&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1707930000&t=53a69bd3d22cc9fe00aa4bb2afb8f7e6"
            />
            <div class="title">香香 OJ</div>
          </div>
        </a-menu-item>
        <a-menu-item v-for="item in visibleRoutes" :key="item.path"
          >{{ item.name }}
        </a-menu-item>
      </a-menu>
    </a-col>
    <a-col flex="100px">
      <div>{{ store.state?.user?.loginUser?.userName ?? "未登录" }}</div>
    </a-col>
  </a-row>
</template>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}

.logo {
  height: 48px;
  border-radius: 40px;
}

.title {
  color: #444;
  margin-left: 16px;
}
</style>
