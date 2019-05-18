<template>
  <router-link :to="{ name: 'user', params: { id: user.id } }">
    <div class="match">
      <div
        class="circle-photo photo"
        v-bind:style="{ 'background-image': 'url(' + user.photos[0] + ')' }"
      ></div>
      <h1>{{ user.firstname }}</h1>
    </div>
  </router-link>
</template>

<script>
export default {
  name: "OneMatch",
  props: ["user"]
};
</script>

<style scoped>
a {
  text-decoration: none;
}
h1 {
  color: #20262e;
  margin-left: 10px;
}
.match {
  padding: 10px;
  height: 80px;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.photo {
  width: 50px;
  height: 50px;
}
a.router-link-exact-active .match {
  color: #fff;
  background-color: #b88782;
}

a.router-link-exact-active .match h1{
  color: #fff;
}
</style>
