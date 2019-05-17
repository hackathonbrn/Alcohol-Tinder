<template>
  <div>
    <Tinder :queue.sync="queue">
      <template slot-scope="{ data }">
        <div class="card-container">
          <div class="info" @click="openFullInfo = !openFullInfo">
            <h1 class="name">{{ data.firstname }}, {{ data.age }}</h1>
            <div class="description">{{ data.description }}</div>
          </div>
          <div
            class="pic"
            :style="`background-image:url(${data.photos[0]})`"
          ></div>
          <FullInfo :user="data" v-if="openFullInfo === true"></FullInfo>
          <!--          <swiper class="swiper" :options="swiperOption" ref="mySwiper">-->
          <!--            <swiper-slide v-for="(photo, index) in data.photos"-->
          <!--              ><div class="pic" :style="`background-image:url(${photo})`"></div-->
          <!--            ></swiper-slide>-->
          <!--          </swiper>-->
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
import FullInfo from "./FullInfo";

export default {
  name: "SwiperScreen",
  components: { FullInfo, Tinder },
  data: () => ({
    openFullInfo: false,
    queue: [
      {
        id: 1,
        key: 1,
        firstname: "Иосиф",
        age: 20,
        photos: [
          "https://pp.userapi.com/c849320/v849320266/165685/wXs4GZAmLUE.jpg",
          "https://sun1-30.userapi.com/c543101/v543101522/25e86/eImlQtjBvGg.jpg"
        ],
        description: "Люблю сидр и котиков"
      },
      {
        id: 2,
        key: 2,
        firstname: "Катя",
        age: 22,
        photos: [
          "https://pp.userapi.com/c848628/v848628728/d0c32/ZCaQ29kujSA.jpg",
          "https://sun1-30.userapi.com/c543101/v543101522/25e86/eImlQtjBvGg.jpg"
        ],
        description: "Люблю сидр и котиков"
      },
      {
        id: 3,
        key: 3,
        firstname: "Андрей",
        age: 24,
        photos: [
          "https://pp.userapi.com/c623900/v623900438/118e59/OTQhAWwF_jM.jpg",
          "https://sun1-30.userapi.com/c543101/v543101522/25e86/eImlQtjBvGg.jpg"
        ],
        description: "Люблю сидр и котиков"
      }
    ]
  }),
  created() {
    // this.getData();
  },
  computed: {
  },
  methods: {
    getActiveIndex: swiper => {
      this.active = swiper.activeIndex;
    },
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
.swiper {
  width: 100%;
  height: 100%;
}
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
