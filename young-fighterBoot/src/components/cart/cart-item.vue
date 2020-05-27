<template>
    <v-card class="my-2">
        <v-card-title primary-title>
            <i>{{ cart_item_data.name }}</i>
        </v-card-title>
        <v-card-text>
            Цена: {{ cart_item_data.price }}
        </v-card-text>
        <v-btn @click="deleteFromCart" small flat><v-icon>delete</v-icon></v-btn>
    </v-card>
</template>

<script>
    export default {
        name: "v-cart-item",
        props: ["cart_item_data"],
        methods: {
            deleteFromCart() {
                this.$emit('deleteFromCart')
            }
        }
    }
</script>

<style>
</style>