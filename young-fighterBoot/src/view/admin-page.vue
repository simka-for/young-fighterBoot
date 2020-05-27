<template>
    <div>
        <div>
            <span class="my-2">
                <v-btn href="/admin/products" x-large color="secondary" dark>Product List</v-btn>
            </span>
            &nbsp;
            <span class="my-2">
                <v-btn href="/admin/orders" x-large color="secondary" dark>Order List</v-btn>
            </span>
        </div>
        <v-container>
            <router-view></router-view>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: "v-admin-page"
    }
</script>

<style>

</style>