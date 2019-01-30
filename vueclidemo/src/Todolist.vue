<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <input class="backgroud" v-model="inputvalue"/>
    <button @click="handlesubmit"></button>
    <ul>
      <todoitem v-for="(item,index) of list" :key="item" :content="item" :index="index" @delete="handledelete"></todoitem>
    </ul>
  </div>
</template>

<script>
import Todoitem from './components/Todoitem.vue'

export default {
  components : {
      'todoitem' : Todoitem
  },
  data () {
      return {
          inputvalue:'',
	  list : []
      }
  },
  methods: {
      handlesubmit () {
          this.list.push(this.inputvalue)
	  this.inputvalue=''
      },
      handledelete (index) {
          this.list.splice(index,1)
      }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
