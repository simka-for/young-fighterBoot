<template>
  <v-app >
    <v-app-bar app>
      <v-toolbar-title><a href="/" id="fot">Young-fighter Shop</a></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon @click="()=> goTo('admin')">
        <v-icon>verified_user</v-icon>
      </v-btn>
      <v-btn icon @click="()=> goTo('cart')">
        <v-icon>shopping_cart</v-icon>{{ cartLength }}
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
  export default {
    name: 'app',
    computed:{
      cartLength(){
        return this.$store.getters.getCartLength
      }
    },
    methods: {
      goTo(name){
        this.$router.push({name: name})
      }
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
