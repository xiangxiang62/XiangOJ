<template id="userLoginView">
  <h1 style="margin-bottom: 16px">用户登录</h1>
  <a-form
    label-align="left"
    auto-label-width
    style="max-width: 480px; margin: 0 auto"
    :model="form"
    @submit="handleSubmit"
  >
    <a-form-item field="userAccount" label="账号">
      <a-input v-model="form.userAccount" placeholder="请输入账号" />
    </a-form-item>
    <a-form-item field="userPassword" tooltip="密码不少于 8 位" label="密码">
      <a-input-password v-model="form.userPassword" placeholder="请输入密码" />
    </a-form-item>
    <a-form-item>
      <a-space>
        <a-button
          html-type="submit"
          style="width: 256px; text-align: center"
          type="primary"
          >登录
        </a-button>
        <a-link href="/user/register">没有账号？去注册</a-link>
      </a-space>
    </a-form-item>
  </a-form>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const form = reactive({
  userAccount: "",
  userPassword: "",
});

const router = useRouter();
const store = useStore();

const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  if (res.code === 0) {
    await store.dispatch("user/getLoginUser");
    alert("登录成功，欢迎你 " + JSON.stringify(res.data.id));
    router.push({
      path: "/",
      replace: true,
    });
  } else {
    message.error("登录失败，" + res.message);
  }
};
</script>

<style scoped></style>
