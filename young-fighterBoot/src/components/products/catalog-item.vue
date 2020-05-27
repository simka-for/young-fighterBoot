<template>
    <v-card class="mx-auto"
            max-width="344">
        <v-list-item three-line>
            <v-list-item-content>
                <div class="overline mb-4">Product</div>
                <v-list-item-title class="headline mb-1">{{ product_data.name }}</v-list-item-title>
                <v-list-item-subtitle>цена: {{ product_data.price }}</v-list-item-subtitle>
                <v-list-item-action-text> описание:  {{ product_data.description }}</v-list-item-action-text>
            </v-list-item-content>

            <v-list-item-avatar
                    tile
                    size="80"
                    color="grey"
            ></v-list-item-avatar>
        </v-list-item>
        <v-card-actions>
            <v-btn @click="addToCart"><v-icon>add_shopping_cart</v-icon></v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "v-catalog-item",
        props: ["product_data"],
        methods: {
            addToCart(){
                sessionStorage.setItem("cart", this.product_data)
                this.$store.dispatch("ADD_TO_CART", this.product_data)
            }
        }
    }
</script>

<style >

</style>