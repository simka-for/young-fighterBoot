<template>
    <div>
        <div>
            <span class="my-2">
                <v-btn @click="()=> goTo('adminProductView')" x-large color="secondary" dark>Product List</v-btn>
            </span>
            &nbsp;
            <span class="my-2">
                <v-btn @click="()=> goTo('catalog')" x-large color="secondary" dark>Order List</v-btn>
            </span>
        </div>
        <v-container>
            <router-view></router-view>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: "v-admin-page",
        methods: {
            goTo(name){
                this.$router.push({name: name})
            }
        }
    }
</script>

<style>

</style>