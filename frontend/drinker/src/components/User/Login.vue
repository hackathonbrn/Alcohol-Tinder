<template>
  <div class='login'>
    <div style="margin: 20px;"></div>
    <el-form label-position="top" label-width="100px" :model="formLabelAlign">
      <el-form-item label="Логин">
        <el-input v-model="formLabelAlign.login"></el-input>
      </el-form-item>
      <el-form-item label="Пароль">
        <el-input v-model="formLabelAlign.password" type="password"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      formLabelAlign: {
        login: "",
        password: ""
      }
    };
  }
};
</script>

<style scoped>
.login {
  padding: 10px;
    height: 100vh;
}
</style>
