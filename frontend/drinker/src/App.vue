<template>
  <div id="app">
    <!--    <Match></Match>-->
    <!--    <div id="nav">-->
    <!--      <router-link to="/profile">Профиль</router-link> |-->
    <!--      <router-link to="/">Поиск</router-link> |-->
    <!--      <router-link to="/matches">Пары</router-link>-->
    <!--    </div>-->
    <!--    <router-view />-->

    <el-container>
      <el-aside class="aside" width="400px"><Aside></Aside></el-aside>
      <el-container id="el-container">
        <router-view></router-view>
      </el-container>
    </el-container>
  </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css?family=Open+Sans&display=swap");
html {
}
.aside {
  /*background-color: #b86841;*/
  background-color: #f6fafd;
  border-color: #2c3e50;
  border-style: solid;
  border: 1px;
}
el-container {
  background-color: #f6fafd;
}
.main {
  position: relative;
  height: calc(100vh - 120px);
}
* {
  margin: 0;
  padding: 0;
}
* {
  box-sizing: border-box;
  font-family: 'Open Sans', sans-serif;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.circle-photo {
  border-radius: 50%;
  border-radius: 50%;
  background-position: center;
  border: 2px;

  border-color: #fff;
  border-style: solid;
}
</style>
<script>
import Match from "./components/Match";
import SwiperScreen from "./components/Swipe";
import Wave from "./components/Wave";
import Aside from "./components/Aside";
export default {
  components: { Aside, Wave, SwiperScreen, Match }
};
</script>
