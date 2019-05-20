<template>
  <div class="box like">
    <img src="https://svgsilh.com/svg/296597.svg" />
  </div>
</template>

<script>
export default {
  name: "Wave"
};
</script>

<style scoped>
.box {
  position: absolute;
  top: calc(50% - 78px);
  left: calc(50% - 78px);
}

img {
  transition: all 0.3s ease;
  width: 150px;
  margin: 4px;
}

.like {
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0% {
    transform: scale(1);
    shadow: 0 0 0 0 rgba(204, 169, 44, 0.4);
  }
  20% {
    transform: scale(1.4);
    shadow: 0 0 0 10px rgba(204, 169, 44, 0.4);
  }
  100% {
    transform: scale(1);
    shadow: 0 0 0 0 rgba(204, 169, 44, 0);
  }
}
</style>
