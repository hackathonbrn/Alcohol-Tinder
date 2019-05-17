<template>
  <div>
    <Tinder :queue.sync="queue">
      <template slot-scope="{ data }">
        <div class="card-container">
          <div class="info">
            <h1 class="name">{{ data.firstname }}, {{ data.age }}</h1>
            <div class="description">{{ data.description }}</div>
          </div>
          <div class="pic" :style="`background-image:url(${data.photo})`"></div>
        </div>
      </template>
      <img
        class="like-pointer"
        slot="like"
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/like-txt.png"
      />
      <img
        class="nope-pointer"
        slot="nope"
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/nope-txt.png"
      />
      <img
        class="super-pointer"
        slot="super"
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/super-txt.png"
      />
    </Tinder>
    <div class="btns">
      <img
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/nope.png"
        @click="decide('nope')"
      />
      <img
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/super-like.png"
        @click="decide('super')"
      />
      <img
        src="https://johnnydan.oss-cn-beijing.aliyuncs.com/vue-tinder/like.png"
        @click="decide('like')"
      />
    </div>
  </div>
</template>

<script>
import Tinder from "vue-tinder";

export default {
  name: "Swiper",
  components: {
    Tinder
  },
  data: () => ({
    queue: [
      {
        id: 1,
        key: 1,
        firstname: "Иосиф",
        age: 20,
        photo:
          "https://pp.userapi.com/c849320/v849320266/165685/wXs4GZAmLUE.jpg",
        description: "Люблю сидр и котиков"
      },
      {
        id: 2,
        key: 2,
        firstname: "Катя",
        age: 22,
        photo:
          "https://pp.userapi.com/c848628/v848628728/d0c32/ZCaQ29kujSA.jpg",
        description: "Люблю сидр и котиков"
      },
      {
        id: 3,
        key: 3,
        firstname: "Андрей",
        age: 24,
        photo:
          "https://pp.userapi.com/c623900/v623900438/118e59/OTQhAWwF_jM.jpg",
        description: "Люблю сидр и котиков"
      }
    ]
  }),
  created() {
    // this.getData();
  },
  computed: {},
  methods: {
    // getData() {
    //   const list = [];
    //   for (let i = 0; i < 200; i++) {
    //     list.push({
    //       key: Math.random()
    //     });
    //   }
    //   this.queue = this.queue.concat(list);
    // },
    decide(choice) {
      this.$refs.tinder.decide(choice);
    },
    submit(choice) {
      switch (choice) {
        case "nope": // 左滑
          break;
        case "like": // 右滑
          break;
        case "super": // 上滑
          break;
      }
      // if (this.queue.length < 2) {
      //   this.getData();
      // }
    }
  }
};
</script>

<style scoped>
.card-container {
  display: flex;
  align-items: flex-end;
  width: 100%;
  height: 100%;
}
.info {
  position: absolute;
  padding: 10px;
  color: #fff;
  width: 100%;
  z-index: 2;
}

.name {
  display: inline-flex;
  align-items: flex-end;
  margin: 0;
}
.description {
}

html,
body {
  height: 100%;
}

body {
  background: #20262e;
  overflow: hidden;
}

[v-cloak] {
  display: none;
}

#app .vue-tinder {
  position: absolute;
  z-index: 1;
  left: 0;
  right: 0;
  top: 23px;
  margin: auto;
  width: calc(100% - 20px);
  height: calc(100% - 23px - 18%);
  min-width: 300px;
  max-width: 355px;
}

.nope-pointer {
  right: 10px;
}
.like-pointer {
  left: 10px;
}
.nope-pointer,
.like-pointer {
  position: absolute;
  z-index: 1;
  top: 20px;
  width: 64px;
  height: 64px;
}
.super-pointer {
  position: absolute;
  z-index: 1;
  bottom: 80px;
  left: 0;
  right: 0;
  margin: auto;
  width: 112px;
  height: 78px;
}

.pic {
  width: 100%;
  height: 100%;
  background-size: cover;
}

.btns {
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  height: 18%;
  display: flex;
  align-items: center;
  justify-content: center;
  min-width: 300px;
  max-width: 355px;
}
.btns img {
  width: 80px;
}
</style>
