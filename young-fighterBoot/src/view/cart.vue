<template>
<v-layout align-center-around justify-start column>
    <h1>Cart</h1>
    <v-cart-item
            v-for="(item, index) in cart"
            :key="item.id"
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
        data() {
            return {
                cart: []
            }
        },
        methods: {
            deleteFromCart(index) {
                this.$store.dispatch("DELETE_FROM_CART",index)
            }
        },
        mounted() {
            if(sessionStorage.getItem('cart')) {
                try {
                    this.cart = (sessionStorage.getItem('cart'));
                } catch(e) {
                    sessionStorage.removeItem('cart');
                }
            }
        }
    }
</script>

<style>

</style>