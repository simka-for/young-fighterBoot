<template>
    <div>
        <input type="text" placeholder="name" v-model="name" />
        <input type="text" placeholder="description" v-model="description"/>
        <input type="text" placeholder="price" v-model="price" class="input-0"/>
        <input type="button" value="save" @click="save" />
    </div>
</template>

<script>
    document.oninput = function() {
        var input = document.querySelector('.input-0');
        input.value = input.value.replace (/\D/g, '');
    }
    function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
    }
    export default {
        props: ['products', "productAttr"],
        data() {
            return {
                name: '',
                description: '',
                price: '',
                id: ''
            }
        },
        watch: {
            productAttr: function (newVal, oldVal) {
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
                    this.$resource('/product{/id}').update({id: this.id}, product).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.products, data.id);
                            this.products.splice(index, 1, data);
                            this.name = ''
                            this.description = ''
                            this.price = ''
                        })
                    )
                } else {

                    this.$resource('/product{/id}').save({}, product).then(result =>
                        result.json().then(data => {
                            this.products.push(data);
                            this.name = '';
                            this.description = '';
                            this.price = '';
                        })
                    )
                }
            }
        }
    }
</script>

<style>

</style>