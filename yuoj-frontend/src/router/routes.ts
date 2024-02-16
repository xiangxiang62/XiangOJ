import { RouteRecordRaw } from "vue-router";
import HomeView from "@/views/ExampleView.vue";
import AdminView from "@/components/AdminView.vue";
import NoAuth from "@/components/NoAuthView.vue";
import NoAuthView from "@/components/NoAuthView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import userLayout from "@/layouts/userLayout.vue";
import userLoginView from "@/views/user/userLoginView.vue";
import userRegisterView from "@/views/user/userRegisterView.vue";
import AddQuestionView from "@/views/question/AddQuestionView.vue";
import ManageQuestionView from "@/views/question/ManageQuestionView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "用户",
    component: userLayout,
    meta: {
      hideInMenu: true,
    },
    children: [
      {
        path: "/user/login",
        name: "用户登录",
        component: userLoginView,
      },
      {
        path: "/user/register",
        name: "用户注册",
        component: userRegisterView,
      },
    ],
  },
  {
    path: "/add/question",
    name: "创建题目",
    component: AddQuestionView,
    /*meta: {
      access: ACCESS_ENUM.ADMIN,
    },*/
  },
  {
    path: "/update/question",
    name: "更新题目",
    component: AddQuestionView,
    /*meta: {
      access: ACCESS_ENUM.ADMIN,
    },*/
  },
  {
    path: "/manage/question",
    name: "管理题目",
    component: ManageQuestionView,
    /*meta: {
      access: ACCESS_ENUM.ADMIN,
    },*/
  },
  {
    path: "/",
    name: "浏览题目",
    component: HomeView,
  },
  {
    path: "/hide",
    name: "隐藏页面",
    component: HomeView,
    meta: {
      hideInMenu: true,
    },
  },
  {
    path: "/noAuth",
    name: "无权限",
    component: NoAuthView,
  },
  {
    path: "/admin",
    name: "管理员可见",
    component: AdminView,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/about",
    name: "关于我的",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];
