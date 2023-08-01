<template>
  <div>
    <form>
      <h2>Deposit Details</h2>
    <label for="full-name">Full Name:</label>
    <input type="text" id="full-name" v-model="fullName" />

    <label for="date">Date:</label>
    <input type="date" id="date" v-model="date" />

    <label for="donor">Donor:</label>
    <input type="text" id="donor" v-model="donor" />

    <label for="material-type">Material Type:</label>
    <select id="material-type" v-model="materialType">
      <option value="Wood">Wood</option>
      <option value="Glass">Glass</option>
      <option value="Hardware">Hardware</option>
    </select>
        <select v-if="materialType === 'Wood'" v-model="woodType">
      <option value="Plywood">Plywood</option>
      <option value="Oak">Oak</option>
      <option value="Pine">Pine</option>
      <option value="Cedar">Cedar</option>
    </select>
    <button v-on:click.prevent="addNewDeposit">Add Deposit</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fullName: '',
      date: '',
      donor: '',
      materialType: 'Wood', 
      woodType: 'Plywood',
    };
  },
  methods: {
    addNewDeposit(){
      const newDeposit = {
        fullName: this.fullName,
        date: this.date,
        donor: this.donor,
        materialType: this.materialType,
        woodType: this.woodType,
      };
      this.$store.dispatch('addDeposit', newDeposit)
       alert("Deposit Logged!");
      this.fullName = '';
      this.date = '';
      this.donor = '';
      this.materialType = 'Wood';
      this.woodType = 'Plywood';

    }
  }
};

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