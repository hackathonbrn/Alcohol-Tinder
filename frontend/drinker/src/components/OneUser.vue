<template>
  <div style="width: 400px; height: 100vh">
    <div
      class="photo"
      v-bind:style="{ 'background-image': 'url(' + user.photo + ')' }"
    ></div>
    <router-link :to="{ name: 'chats', params: { id: user.id } }">
      <el-button type="info" icon="el-icon-message" circle></el-button
    ></router-link>

    <h1>{{ user.firstName }}, {{ user.age }}</h1>
    <p>Люблю сидр и котиков</p>
  </div>
</template>

<script>
export default {
  name: "OneUser",
  data() {
    return {
      user: {
        id: 1,
        firstName: "Имя",
        secondName: "Фамилия",
        age: 19,
        photo:
          "http://lamcdn.net/lookatme.ru/post-cover/YTs4AdwURuPWdki4OJW8jQ-default.jpg"
      }
    };
  },
  created() {
    // this.axios.get().then(res => {
    //   this.user = res.data;
    // });
  }
};
</script>

<style scoped>
.photo {
  width: 400px;
  height: 400px;
  background-color: #42b983;
  background-position: center;
}
</style>
