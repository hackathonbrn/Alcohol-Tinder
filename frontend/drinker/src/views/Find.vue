<template>
  <div class="about">
    <Swiper></Swiper>
    <wave></wave>
  </div>
</template>
<script>
import Swiper from "../components/SwiperScreen";
import Wave from "../components/Wave";
export default {
  name: 'Find',
  components: {Wave, Swiper }
};
</script>
