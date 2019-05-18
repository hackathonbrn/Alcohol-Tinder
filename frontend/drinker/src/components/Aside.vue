<template>
  <div id="aside">
    <router-link :to="{name: 'profile'}">
      <div class="nav">
          <router-link :to="{name: 'search'}">
          <span v-if="$route.name === 'profile'">назад</span>
          </router-link>
        <div
          class="photo"
          v-bind:style="{ 'background-image': 'url(' + user.photos[0] + ')' }"
        ></div>
        <h1>Мой профиль</h1>
      </div>
    </router-link>
    <div class="matches">
      <OneMatch v-for="match in user.matches" :user="match"></OneMatch>
    </div>
  </div>
</template>

<script>
import OneMatch from "./OneMatch";
export default {
  name: "Aside",
  components: { OneMatch },
  computed: {
    user() {
      return this.$store.state.user;
    }
  }
};
</script>

<style scoped>
h1 {
  margin-left: 10px;
}
#aside {
  height: 100vh;
}
.nav {
  height: 80px;
  display: flex;
  flex-direction: row;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  height: 80px;
  width: 400px;
  background-color: #b86841;
}
.photo {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  border-radius: 50%;
  background-position: center;
  border: 2px;
  border-color: white;
  border-style: solid;
}
</style>
