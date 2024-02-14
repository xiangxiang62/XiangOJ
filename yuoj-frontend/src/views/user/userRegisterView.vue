<template id="userRegisterView">
  <h1 style="margin-bottom: 16px">用户注册</h1>
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
    <a-form-item
      field="checkPassword"
      tooltip="密码不少于 8 位"
      label="确认密码"
    >
      <a-input-password
        v-model="form.checkPassword"
        placeholder="再次输入密码"
      />
    </a-form-item>
    <a-form-item>
      <a-space>
        <a-button
          html-type="submit"
          style="width: 256px; text-align: center"
          type="primary"
          >注册
        </a-button>
        <a-link href="/user/login">已有账号？去登录</a-link>
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
  checkPassword: "",
});

const router = useRouter();
const store = useStore();

const handleSubmit = async () => {
  const res = await UserControllerService.userRegisterUsingPost(form);
  if (res.code === 0) {
    alert("注册成功");
    router.push({
      path: "/user/login",
      replace: true,
    });
  } else {
    message.error("注册失败，" + res.message);
  }
};
</script>

<style scoped></style>
