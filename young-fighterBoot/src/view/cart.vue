<template>
<v-layout align-center-around justify-start column>
    <h1>Cart</h1>
    <v-cart-item
            v-for="(item, index) in getCart"
            :key="`cart-item-${index}`"
            :cart_item_data="item"
            @deleteFromCart="deleteFromCart(index)"
    />
</v-layout>
</template>

<script>
    import vCartItem from '../components/cart/cart-item.vue'

    export default {
        name: "v-cart",
        components: {
            vCartItem
        },

        methods: {
            deleteFromCart(index) {
                this.$store.dispatch("DELETE_FROM_CART",index)
            }
        },
        computed:{
            getCart(){
                return this.$store.getters.getCart
            }
        }

    }
</script>

<style>

</style>