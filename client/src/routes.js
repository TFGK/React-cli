import Dashboard from "views/Dashboard.jsx";
import UserProfile from "views/UserProfile.jsx";
import Maps from "views/Maps.jsx";
import Create from "views/Create.jsx";
import TableList from "views/TableList.jsx";
import Main from "views/Main.js";

import Login from "views/Login.jsx";
import Register from "views/Register.jsx";

const dashboardRoutes = [
  {
    path:"/main",
    name:"Main",
    kname:"メインページ",
    icon:"pe-7s-board",
    component: Main,
    layout:"/admin"
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    kname:"マップデータ",
    icon: "pe-7s-graph",
    component: Dashboard,
    layout: "/admin"
  },
  
  {
    path: "/userprofile",
    name: "UserProfile",
    kname:"プロフィール",
    icon: "pe-7s-user",
    component: UserProfile,
    layout: "/admin"
  },
  {
    path: "/maps",
    name: "Maps",
    kname:"データ登録",
    icon: "pe-7s-map-marker",
    component: Maps,
    layout: "/admin"
  },
  

  //table
  {
    path: "/create",
    name: "Create",
    kname:"投稿",
    icon: "pe-7s-user",
    component: Create,
    layout: "/admin"
  },
  //table
  {
    path: "/table",
    name: "board",
    kname:"掲示板",
    icon: "pe-7s-note2",
    component: TableList,
    layout: "/admin"
  },

  // auth
  {
    path: "/login",
    component: Login,
    layout: "/admin"
  },
  {
    path: "/register",
    component: Register,
    layout: "/admin"
  },
];

export default dashboardRoutes;
