<template>
    <v-layout align-center-around justify-start row>
        <product-row v-for="product in products"
                     :key="product.id"
                     :product="product"
                     :products="products"/>
    </v-layout>
</template>

<script>
    import ProductRow from './ProductRow.vue'
    export default {
        props: ['products'],
        components: {
            ProductRow,
        },
        data () {
            return {
                product: null
            }}
    }
</script>

<style>

</style>