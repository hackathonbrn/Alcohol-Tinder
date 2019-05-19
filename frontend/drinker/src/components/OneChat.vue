<template>
  <div class="one-chat" style="width: 400px; height: 100vh">
    <p>Люблю сидр и котиков</p>
  </div>
</template>

<script>
export default {
  name: "OneChat",
  data() {
    return {
      user: {
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
.one-chat {
  top: 0;
  left: 400px;
}
</style>
