import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    queue: [
      {
        id: 1,
        firstname: "Иосиф",
        age: 20,
        photo:
          "https://pp.userapi.com/c849320/v849320266/165685/wXs4GZAmLUE.jpg",
        description: "Люблю сидр и котиков"
      },
      {
        id: 2,
        firstname: "Катя",
        age: 22,
        photo:
          "https://pp.userapi.com/c848628/v848628728/d0c32/ZCaQ29kujSA.jpg",
        description: "Люблю сидр и котиков"
      },
      {
        id: 3,
        firstname: "Андрей",
        age: 24,
        photo:
          "https://pp.userapi.com/c623900/v623900438/118e59/OTQhAWwF_jM.jpg",
        description: "Люблю сидр и котиков"
      }
    ]
  },
  mutations: {},
  actions: {}
});
