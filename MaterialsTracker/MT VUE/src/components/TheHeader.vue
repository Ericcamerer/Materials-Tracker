<template>
  <header>
      <img class = "header-image" src="https://st3.depositphotos.com/10480338/15642/v/600/depositphotos_156426560-stock-illustration-mt-business-vector-logo-design.jpg" alt="MT Logo">
      <h1>Materials Tracker</h1>
      <nav>
      <router-link to="/">Deposit</router-link> |
      <router-link to="/login">Login</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'TheHeader',
};
</script>

<style>

header {
    display: flex;
    justify-content:flex-start;
    margin-bottom: 5px;
    
    background-color: #507DBC;
    border-radius: 10px;
    flex-direction: row;
    align-items: center;
    width: 100%;
}

.header-image {
  margin-left: 20px;
  margin-right:20px;
  border-radius: 50%;
  height: 70px; 
  object-fit: cover;

}
nav {
  font-size: 20px;
  margin-left: 65%;
}
</style>