<template>
    <div><i>{{ product.name }}</i>, описание:  {{ product.description }}, цена: {{ product.price }}
        <span style="position: absolute; right: 0">
            <input type="button" value="edit" @click="edit" />
            <input type="button" value="del" @click="del" />
        </span></div>
</template>

<script>
    export default {
        props: ['product', 'editProduct', 'deleteProduct', 'products'],
        methods: {
            edit () {
                this.editProduct(this.product);
            },
            del () {
                this.deleteProduct(this.product)
            }
        }
    }

</script>

<style>

</style>