<template>
    <div style="position: relative; width: 400px">
        <ProductForm :products="products" :productAttr="product" />
       <br/>
        <product-row v-for="product in products"
                     :key="product.id"
                     :product="product"
                     :products="products"
                     :editProduct="editProduct"
                     :deleteProduct="deleteProduct"/>
    </div>
</template>

<script>
    import ProductRow from 'components/products/ProductRow.vue'
    import ProductForm from 'components/products/ProductForm.vue'
    export default {
        props: ['products'],
        components: {
            ProductRow,
            ProductForm
        },
        data () {
            return {
                product: null
            }
        },
        methods: {
            editProduct (product) {
                this.product = product;
            },
            deleteProduct (product) {
                this.$resource('/product{/id}').remove({id: product.id}).then(result =>{
                if (result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1)
                }
                })
            }
        }
    }
</script>

<style>

</style>