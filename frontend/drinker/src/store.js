import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {
      id: 100,
      firstname: "Николай",
      age: 25,
      photos: [
        "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
      ],
      matches: [
        {
          id: 101,
          firstname: "Николай",
          age: 25,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 102,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 103,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 104,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 105,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 106,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 107,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 108,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 109,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 110,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 111,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 112,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 113,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 114,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 115,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        },
        {
          id: 116,
          firstname: "Петр",
          age: 27,
          photos: [
            "https://images.unsplash.com/photo-1558068078-7a6b350aed4a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
          ]
        }
      ]
    },
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
