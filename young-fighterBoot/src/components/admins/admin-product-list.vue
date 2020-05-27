<template>
    <div>
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
        <edit-form
                v-if="editFormVis"
                @closeForm="closeForm"
                @updateProduct="updateProduct"
        >
            <v-text-field  label="name" v-model="product.name" />
            <v-text-field  label="description"  v-model="product.description"/>
            <v-text-field  label="price" v-model="product.price" type="number" min="0"/>
            <div id="btn">
                <v-btn @click="updateProduct" value="save">
                    <v-icon>save</v-icon>
                </v-btn>
            </div>
        </edit-form>
    </div>
</template>

<script>
    import editForm from "./popup/edit-form.vue"

    const axios = require('axios').default;

    export default {
        name: "v-admin-product-list",
        props: ['product', 'editProduct', 'deleteProduct', 'products'],
        components: {
            editForm
        },
        data() {
            return {
                editFormVis: false
            }
        },
        methods: {
            edit() {
                this.editFormVis = true;
            },
            closeForm() {
                this.editFormVis = false;
            },
            del() {
                this.deleteProduct(this.product)
            },
            updateProduct() {
                const product = {
                    name: this.product.name,
                    description: this.product.description,
                    price: this.product.price
                };
                axios.put(`http://localhost:9000/admin/products/${this.product.id}`, product)
                this.editFormVis = false;
            }
        }
    }
</script>

<style>
</style>