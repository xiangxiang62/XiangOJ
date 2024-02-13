<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="head">
        <a-space>
          <img
            src="https://img1.baidu.com/it/u=3885902702,1497811734&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1708016400&t=781b0ce9c612af24b065b8e70eaa6fc8"
            class="logo"
          />
          <div>香香 OJ</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">底部</a-layout-footer>
    </a-layout>
  </div>
</template>
<style scoped>
#userLayout {
}

#userLayout {
  text-align: center;
  background: url("https://img2.baidu.com/it/u=1850493911,2433536571&fm=253&fmt=auto&app=138&f=JPEG?w=700&h=400")
    0% 0% / 100% 100%;
}

#userLayout .logo {
  width: 64px;
  height: 64px;
}

#userLayout .head {
  margin-top: 156px;
}

#userLayout .content {
  margin-bottom: 16px;
  padding: 20px;
}

#userLayout .footer {
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
</style>
<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
</script>
