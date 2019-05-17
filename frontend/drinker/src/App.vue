<template>
  <div id="app">
    <Match></Match>
    <div id="nav">
      <router-link to="/profile">Профиль</router-link> |
      <router-link to="/">Поиск</router-link> |
      <router-link to="/matches">Пары</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
}
* {
  box-sizing: border-box;
}
#app {
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
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
</style>
<script>
import Match from "./components/Match";
export default {
  components: { Match }
};
</script>
