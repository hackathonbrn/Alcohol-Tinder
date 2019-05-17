<template>
  <div>
    <h1>{{ user.firstname }}, {{ user.age }}</h1>
    <div class="description">Люблю сидр и котиков</div>
    <br />
    <div>
      Напитки
    </div>
    <div>
      Увлечения
    </div>
  </div>
</template>

<script>
export default {
  name: "FullInfo",
  props: ["user"]
};
</script>

<style scoped></style>
