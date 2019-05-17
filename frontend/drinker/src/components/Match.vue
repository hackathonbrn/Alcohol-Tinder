<template>
  <div>
    <div class="content">
        <h1>Кто-то будет пить</h1>
    </div>
    <div class="bg"></div>
  </div>
</template>

<script>
export default {
  name: "Match"
};
</script>

<style scoped>
.bg {
  display: block;
    opacity: 0.8;
  position: absolute;
  width: 100vw;
  height: 100vh;
  z-index: 10;
  background: #20262e;
  /*filter: blur(9px);*/
}
    .content{
        z-index: 12;
        top: 0;
        left: 0;
        position: absolute;
        color: white;
    }
</style>
