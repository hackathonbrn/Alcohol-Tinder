import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import Search from "./views/Search";
import Matches from "./views/Matches";
import Profile from "./views/Profile";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/matches/:id",
      name: "user",
      component: Matches
    },
    {
      path: "/search",
      name: "search",
      component: Search
    },
    {
      path: "/profile",
      name: "profile",
      component: Profile
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
        import(/* webpackChunkName: "about" */ "./views/Search.vue")
    }
  ]
});
