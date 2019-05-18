import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import Find from "./views/Find";
import User from "./views/User";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/user/:id",
      name: "user",
      component: User
    },
    {
      path: "/",
      name: "find",
      component: Find
    },
    {
      path: "/profile",
      name: "profile",
      component: Home
    },
    {
      path: "/matches",
      name: "matches",
      component: Home
    },
    {
      path: "/",
      name: "find",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "./views/Find.vue")
    }
  ]
});
