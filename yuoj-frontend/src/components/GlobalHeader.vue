<script setup lang="ts">
import { routes } from "@/router/routes";
import { useRouter } from "vue-router";
import { ref } from "vue";
import { useStore } from "vuex";

const router = useRouter();
const doMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};

const store = useStore();
console.log(store.state.user.loginUser);

/*
setTimeout(() => {
  store.dispatch("user/getLoginUser", {
    userName: "香香",
    role: "admin",
  });
}, 3000);
*/

// 默认主页
const selectedKeys = ref(["/"]);

// 路由跳转时，更新选中的菜单项
router.afterEach((to, from, failure) => {
  selectedKeys.value = [to.path];
});
</script>

<template>
  <a-row id="globalHeader" style="margin-bottom: 16px" align="center">
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
              src="https://img2.baidu.com/it/u=2477548932,1618898030&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1707843600&t=b11389919f4146d601ff0d96aadfda0f"
            />
            <div class="title">香香 OJ</div>
          </div>
        </a-menu-item>
        <a-menu-item v-for="item in routes" :key="item.path"
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
