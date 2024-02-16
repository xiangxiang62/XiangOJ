<template>
  <div id="exampleView">
    <code-editor :value="codeValue" :handle-change="onCodeChange" />
    <md-editor :value="mdValue" :handle-change="onMdChange" />
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import HelloWorld from "@/components/HelloWorld.vue";
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue"; // @ is an alias to /src

const codeValue = ref();
const mdValue = ref();

const onCodeChange = (v: string) => {
  codeValue.value = v;
};

const onMdChange = (v: string) => {
  mdValue.value = v;
};
</script>
