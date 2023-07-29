<template>
  <header>
      <h1>Materials Tracker</h1>
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
    justify-content: space-evenly;
    gap: 10px;
    padding: 20px;
    background-color: rgba(34, 139, 34, 0.5);
    border-radius: 10px;
    flex-direction: column;
    align-items: center;
    width: 95%;
}
</style>