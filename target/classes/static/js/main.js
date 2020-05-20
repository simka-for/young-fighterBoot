var productApi = Vue.resource('/product{/id}');

function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

Vue.component('addProduct-form', {
    props: ['products', "productAttr"],
    data: function(){
        return {
            name: '',
            description: '',
            price: '',
            id: ''
        }
    },
    watch: {
        productAttr: function(newVal, oldVal) {
            this.name = newVal.name;
            this.description = newVal.description;
            this.price = newVal.price;
            this.id = newVal.id;
        }
    },
    template:'<div>' +
        '<input type="text" placeholder="name" v-model="name" />' +
        '<input type="text" placeholder="description" v-model="description"/>\'' +
        '<input type="text" placeholder="price" v-model="price" class="input-0"/>\'' +
        '<input type="button" value="save" @click="save" />' +
        '</div>',
    methods: {
        save: function () {
            var product = { name: this.name, description: this.description, price: this.price};

            if (this.id) {
                productApi.update({id: this.id}, product).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.products, data.id);
                        this.products.splice(index, 1, data);
                        this.name = ''
                        this.description = ''
                        this.price = ''
                    })
                )
            } else {

            productApi.save({}, product).then(result =>
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
});

Vue.component('product-row', {
    props: ['product', 'editMethod', 'products'],
    template: '<div><i>{{ product.name }}</i>, описание:  {{ product.description }}, цена: {{ product.price }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="edit" @click="edit" />' +
        '<input type="button" value="del" @click="del" />' +
        '</span></div>',
    methods: {
        edit:function () {
            this.editMethod(this.product);
        },
        del:function () {
            productApi.remove({id: this.product.id}).then(result =>{
                if (result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1)
                }
            })
        }
    }

})

Vue.component('product-list', {
    props: ['products'],
    data: function() {
        return {
            product: null
        }
    },
    template: '<div style="position: relative; width: 400px">' +
        '<addProduct-form :products="products" :productAttr="product" />' +
        '<br/>' +
        '<product-row v-for="product in products" :key="product.id" :product="product" ' +
        ':products="products"  :editMethod="editMethod" /></div>',

    methods:{
        editMethod: function (product) {
            this.product = product;
        }
    }
});


var app = new Vue({
    el: '#app',
    template: '<product-list :products="products"/>',
    data: {
        products: []
    },
    created: function () {
        productApi.get().then(result =>
            result.json().then(data =>
                data.forEach(product => this.products.push(product))
            )
        )
    },
})

document.oninput = function() {
    var input = document.querySelector('.input-0');
    input.value = input.value.replace (/\D/g, '');
}