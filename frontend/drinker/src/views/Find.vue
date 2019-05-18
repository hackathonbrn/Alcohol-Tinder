<template>
  <div>
    <div class="menu"></div>
    <div>
      <Swiper></Swiper>
      <wave></wave>
    </div>
  </div>
</template>
<script>
import Swiper from "../components/SwiperScreen";
import Wave from "../components/Wave";
import Match from "../components/Match";
export default {
  name: "Find",
  components: { Match, Wave, Swiper }
};
</script>

<style scoped>
.menu {
  background-color: chocolate;
  height: 100vh;
  width: 30ex;
}
</style>
