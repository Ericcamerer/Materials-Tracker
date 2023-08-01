<template>
  <div class="home">
    <the-header />
    <deposit-form />
  </div>
</template>

<script>
// @ is an alias to /src
import TheHeader from '@/components/TheHeader.vue'
import DepositForm from '@/components/DepositForm.vue'

export default {
  name: 'HomeView',
  components: {
    TheHeader,
    DepositForm
  }
}
</script>
