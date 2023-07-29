<template>
  <div>
    <label for="full-name">Full Name:</label>
    <input type="text" id="full-name" v-model="fullName" />

    <label for="date">Date:</label>
    <input type="date" id="date" v-model="date" />

    <label for="donor">Donor:</label>
    <input type="text" id="donor" v-model="donor" />

    <label for="material-type">Material Type:</label>
    <select id="material-type" v-model="materialType">
      <option value="wood">Wood</option>
      <option value="glass">Glass</option>
      <option value="hardware">Hardware</option>
    </select>
    <button v-on:click="addNewDeposit">Add Deposit</button>

  </div>
</template>

<script>
export default {
  data() {
    return {
      fullName: '',
      date: '',
      donor: '',
      materialType: 'wood', 
    };
  },
  methods: {
    addNewDeposit(){
      const newDeposit = {
        fullName: this.fullName,
        date: this.date,
        donor: this.donor,
        materialType: this.materialType,
      };
      this.$store.dispatch('addDeposit', newDeposit)

      this.fullName = '';
      this.date = '';
      this.donor = '';
      this.materialType = 'wood';
    }
  }
};

</script>

<style>
div {
    display: flex;
    justify-content: space-evenly;
    gap: 10px;
    padding: 20px;
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
}
</style>