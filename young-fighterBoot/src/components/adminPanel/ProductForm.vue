<template>
    <div>
        <v-text-field  label="name" v-model="name" />
        <v-text-field  label="description"  v-model="description"/>
        <v-text-field  label="price" v-model="price" type="number" min="0"/>
        <v-btn @click="save">
            save
        </v-btn>
    </div>
</template>

<script>
    document.oninput = function() {
        const input = document.querySelector('.input-0');
        input.value = input.value.replace (/\D/g, '');
    }
    function getIndex(list, id) {
    for (let i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
    }
    const axios = require('axios').default;
    export default {
        props: ['products', "productAttr"],
        data() {
            return {
                name: '',
                description: '',
                price: '',
                id: '',
                input: [

                ]
            }
        },
        watch: {
            productAttr: function (newVal) {
                this.name = newVal.name;
                this.description = newVal.description;
                this.price = newVal.price;
                this.id = newVal.id;
            }
        },
        methods: {
            save () {
                const product = {name: this.name, description: this.description, price: this.price};

                if (this.id) {
                    axios.put(`http://localhost:9000/admin/products/${this.id}`, product).then(product => {
                        const index = getIndex(this.products, this.id);
                        this.products.splice(index, 1, product.data);
                        this.name = ''
                        this.description = ''
                        this.price = ''
                    });
                } else {
                    axios.post('http://localhost:9000/admin/products', product).then(product => {
                        this.products.push(product.data);
                        this.name = '';
                        this.description = '';
                        this.price = '';
                    })

                }
            }
        }
    }
</script>

<style>

</style>