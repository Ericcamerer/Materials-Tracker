<template>
  <div id="app">
    <the-header style="grid-area: header" />
    <deposit-form style="grid-area: main" />
  </div>
</template>

<script>
import DepositForm from "./components/DepositForm.vue";
import TheHeader from "./components/TheHeader.vue";

export default {
  name: "App",
  components: {
    DepositForm,
    TheHeader,
  },
};
</script>

<style>
#app {
  display: grid;
  grid-template-columns: 100px 1fr 100px;
  grid-template-rows: 100px 1fr 100px;
  grid-template-areas:
    "header header header"
    "main main main"
    "footer footer footer";
  height: 100vh;

  background: #fafafa;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #22487d;
}
</style>
