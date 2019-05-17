<template>
  <div class="about">
    <Swiper></Swiper>
    <wave></wave>
  </div>
</template>
<script>
import Swiper from "../components/SwiperScreen";
import Wave from "../components/Wave";
import Match from "../components/Match";
export default {
  name: 'Find',
  components: {Match, Wave, Swiper }
};
</script>
