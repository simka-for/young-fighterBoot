<template>
  <v-app >
    <v-app-bar app>
      <v-toolbar-title><a href="/" id="fot">Young-fighter Shop</a></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon href="/admin">
        <v-icon>verified_user</v-icon>
      </v-btn>
    </v-app-bar>
    <br>
    <v-content>
      <v-container>
        <router-view :products="products"></router-view>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
  const axios = require('axios').default;

  export default {
    data() {
      return {
        products: []
      }
    },
    mounted() {
      axios
              .get('http://localhost:9000/')
              .then(response => (
                      this.products = response.data));
    }
  }
</script>

<style>
  a{
    text-decoration:none;
  }
  #fot{
    color: black;
  }
</style>
