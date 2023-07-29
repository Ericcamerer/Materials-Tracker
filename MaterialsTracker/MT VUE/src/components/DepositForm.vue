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

    <!-- You can add a button or any other functionality as needed -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      fullName: '',
      date: '',
      donor: '',
      materialType: 'wood', // Default value, change as needed
    };
  },
};
</script>