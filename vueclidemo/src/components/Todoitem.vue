<template>
  <li class="item" @click="handledelete">{{content}}</li>
</template>

<script>
export default {
  props:['content','index'],
  methods:{
    handledelete () {
      this.$emit('delete',this.index)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.item{
    color:green;
}
</style>
<style>
.backgroud{
    background-color:red;
}
</style>
