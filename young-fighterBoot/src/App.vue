<template>
  <div>
    <product-list :products="products"/>
  </div>
</template>

<script>
  import ProductList from 'components/ProductList.vue'

  export default {
    components: {
      ProductList
    },
    data() {
      return {
        products: frontendData.product
      }
    }
  }
</script>

<style>

</style>
