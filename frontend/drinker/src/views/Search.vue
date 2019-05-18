<template>
  <div class="search">
    <el-header>Header</el-header>
    <el-main class="main"><Swipe /><wave></wave></el-main>
    <el-footer>Footer</el-footer>
  </div>
</template>
<script>
import Swipe from "../components/Swipe";
import Wave from "../components/Wave";
export default {
  name: "Search",
  components: {Wave, Swipe }
};
</script>

<style scoped>
.menu {
  background-color: chocolate;
  height: 100vh;
  width: 30ex;
}

  .search{
    width: 100%;
  }
</style>
