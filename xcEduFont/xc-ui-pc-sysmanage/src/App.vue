<template>
  <div>
      <router-view>1</router-view>
    </div>
</template>

<script>
export default {

  data() {
    return {
      name: 'app'
    }
  },
  methods: {

    },
  created: function(newPath) {
  }
}
</script>

<style>
  * {
    -webkit-user-select:text;
  }
</style>
