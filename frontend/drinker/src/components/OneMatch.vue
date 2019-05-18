<template>
  <router-link :to="{ name: 'user', params: { id: user.id } }">
    <div class="match">
      <div></div>
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
.match {
  height: 80px;
}
a.router-link-exact-active .match {
  color: #42b983;
  background-color: #b86841;
}
</style>
