<template>
  <div class="login">
    <the-header />
    <login-form />
  </div>
</template>

<script>

import TheHeader from '@/components/TheHeader.vue'
import LoginForm from '@/components/LoginForm.vue'

export default {
  name: 'LoginView',
  components: {
    TheHeader,
    LoginForm
  }
}
</script>
