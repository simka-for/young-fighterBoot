<template>
    <v-layout align-center-around justify-start row>
        <admin-add-product-form :products="products" :productAttr="product"/>
        <admin-product-list id="margin"
                v-for="product in products"
                :key="product.id"
                :product="product"
                :products="products"
                :editProduct="editProduct"
                :deleteProduct="deleteProduct"
        />
    </v-layout>
</template>

<script>
    const axios = require('axios').default;
    import adminProductList from './admin-product-list.vue'
    import adminAddProductForm from './admin-add-product-form.vue'

    export default {
        name: "v-admin-product-page",
        components: {
          adminAddProductForm,
          adminProductList
        },
        data() {
            return {
                product: null,
                products: []
            }
        },
        mounted() {
            // this.$store.dispatch()
            // this.$store.getters.CART
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
    #margin{
        margin-bottom: 30px;
        margin-left: 30px;
        margin-top: 20px;
    }
</style>