<template>
    <v-card class="mx-auto"
            max-width="344">
        <v-list-item three-line>
            <v-list-item-content>
                <div class="overline mb-4">Product</div>
                <v-list-item-title class="headline mb-1">{{ product.name }}</v-list-item-title>
                <v-list-item-subtitle>цена: {{ product.price }}</v-list-item-subtitle>
                <v-list-item-action-text> описание:  {{ product.description }}</v-list-item-action-text>
            </v-list-item-content>

            <v-list-item-avatar
                    tile
                    size="80"
                    color="grey"
            ></v-list-item-avatar>
        </v-list-item>
        <v-card-actions>
            <v-btn value="edit" @click="edit" ><v-icon>edit</v-icon></v-btn>
            <v-btn value="del" @click="del"><v-icon>delete_forever</v-icon></v-btn>
        </v-card-actions>
    </v-card>
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