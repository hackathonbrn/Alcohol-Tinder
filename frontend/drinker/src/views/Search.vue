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
  components: {Wave, Swipe },
  created(){
    this.axios.get('http://192.168.1.39:8080/api/getUser/1').then((response) => {
      console.log(response.data)
    })
  }
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
