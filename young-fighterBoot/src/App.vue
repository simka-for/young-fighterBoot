<template>
  <v-app >
    <v-app-bar app>
      <v-toolbar-title><a href="/" id="fot">Young-fighter Shop</a></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon href="/admin">
        <v-icon>verified_user</v-icon>
      </v-btn>
      <v-btn icon href="/cart">
        <v-icon>shopping_cart</v-icon>{{ CART.length }}
      </v-btn>
    </v-app-bar>
    <v-content>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-content>
  </v-app>

</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    name: 'app',
    computed:{
      ...mapGetters([
        'CART'
      ])
    },
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
