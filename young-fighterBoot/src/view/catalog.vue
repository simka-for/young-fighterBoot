<template>
    <v-layout align-center-around justify-start row class="pad">
        <v-catalog-item id="margin"
                v-for="product in products"
                :key="product.id"
                :product_data="product"
        />
    </v-layout>
</template>

<script>
import vCatalogItem from '../components/products/catalog-item.vue'
const axios = require('axios').default;

export default {
    name: "v-catalog",
    components: {
        vCatalogItem
    },
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

<style >
    #margin{
        margin-bottom: 30px;
    }
</style>