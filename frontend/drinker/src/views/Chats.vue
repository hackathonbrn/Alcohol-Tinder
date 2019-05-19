<template>
  <div class="chats">
    <OneUser></OneUser>
    <OneChat></OneChat>
  </div>
</template>

<script>
import OneUser from "../components/OneUser";
import OneChat from "../components/OneChat";
export default {
  name: "Matches",
  components: { OneUser, OneChat }
};
</script>

<style scoped>
.chats {
  display: flex;
    flex-direction: column;
}
</style>
