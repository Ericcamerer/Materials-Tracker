<template>
   <div>
    <form action="">
      <h2>Donation Details</h2>
    <label for="username">Username:</label>
    <input type="text" id="username" v-model="username" />

    <label for="password">Password:</label>
    <input type="password" id="password" v-model="password" />

    <button v-on:click.prevent="loginUser">Log In</button>
    </form>
  </div>
</template>

<script>

export default {
  data() {
    return {
      username: '',
      password: '',
    };
    
  },

  methods: {
      loginUser(){
        //   Method should send login credentials to the /login endpoint API. If user isn't found, should offer to send them to a Register page
        alert("You have been successfully logged in!")
        this.username = '',
        this.password = ''
      }
  }

}
</script>

<style>
div > form {
    display: flex;
    justify-content: space-evenly;
    gap: 5px;
    padding: 10px;
    background-color: lightblue;
    border-radius: 10px;
    flex-direction: column;
    align-items: flex-start;
}


label {
  font-weight: bold;
}

input,
select {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 8px;
  margin-bottom: 10px;
  width: 200px;
}
button {
  padding: 10px 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
  background-color: #2274C6;
  font-weight: bold;
  color: #ffffff;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
}
option {
 padding: 10px;
}

button:hover{
  background-color: #22487D;
}
</style>