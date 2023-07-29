<template>
  <div id="app">
    <the-header />
    <deposit-form/>
  </div>
</template>

<script>
import DepositForm from './components/DepositForm.vue'
import TheHeader from './components/TheHeader.vue'


export default {
  name: 'App',
  components: {
    DepositForm,
    TheHeader
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
