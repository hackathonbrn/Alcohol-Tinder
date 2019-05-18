<template>
  <div v-if="visibility">
    <div class="content" >
      <h1>Кто-то будет пить</h1>
      <div>
        <div
          class="photo"
          v-bind:style="{
            'background-image':
              'url(https://images.unsplash.com/photo-1502898295-455afaf0f015?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60)'
          }"
        ></div>
        <div
          class="photo"
          v-bind:style="{
            'background-image':
              'url(https://images.unsplash.com/photo-1502898295-455afaf0f015?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60)'
          }"
        ></div>
      </div>
      <el-button @click="visibility = false">CСкрыть</el-button>
    </div>
    <div class="bg"></div>
  </div>
</template>

<script>
export default {
  name: "Match",
  data() {
    return {
      visibility: true
    };
  }
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
.content {
  z-index: 12;
  top: 0;
  left: 0;
  position: absolute;
  color: white;
}

.photo {
  height: 200px;
  width: 200px;
  border-radius: 50%;
  background-position: center;
  border: 2px;
  border-color: white;
  border-style: solid;
}
</style>
