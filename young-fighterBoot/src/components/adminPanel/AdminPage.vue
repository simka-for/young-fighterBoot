<template>
    <v-layout align-center-around justify-start row>
        <ProductForm :products="products" :productAttr="product" />
        <br/>
        <product-row v-for="product in products"
                     :key="product.id"
                     :product="product"
                     :products="products"
                     :editProduct="editProduct"
                     :deleteProduct="deleteProduct"/>

    </v-layout>
</template>

<script>
    import ProductRow from './ProductRow.vue'
    import ProductForm from './ProductForm.vue'
    const axios = require('axios').default;
    export default {
        components: {
            ProductRow,
            ProductForm,
        },
        data () {
            return {
                product: null,
                products: []
            }
        },
        mounted() {
            axios
                .get('http://localhost:9000/')
                .then(response => (
                    this.products = response.data));
        },
        methods: {
            editProduct (product) {
                this.product = product;
            },
            deleteProduct (product) {
                axios.delete(`http://localhost:9000/admin/products/${product.id}`).then(
                    () =>
                        this.products.splice(this.products.indexOf(product), 1)
                ).catch(error => console.log(error))
            }
        }
    }
</script>

<style>

</style>