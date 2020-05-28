import Vue from 'vue'
import VueRouter from 'vue-router'
import AppVue from '../App.vue'
import vCatalog from '../view/catalog.vue'
import AdminPage from "../view/admin-page.vue"
import AdminProductPage from "../components/admins/admin-product-view.vue"
import vCart from "../view/cart.vue"
import userContainer from "../view/user-container.vue"
import adminContainer from "../view/admin-container.vue"

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: AppVue,
        name: "App",
        children: [
            {
                path: '/',
                name: 'home',
                redirect: {
                    name: 'catalog'
                },
            },
            {
                path: "user-container",
                component: userContainer,
                name: "user-container",
                children:[
                    {
                        path: 'catalog',
                        name: 'catalog',
                        component: vCatalog,
                    },
                    {
                        path: 'cart',
                        name: 'cart',
                        component: vCart
                    }
                ]
            },
            {
                path: "admin-container",
                component: adminContainer,
                name: "admin-container",
                children: [
                    {
                        path: "admin",
                        name: "admin",
                        component: AdminPage,
                        children: [
                            {
                                path: "admin/products",
                                name: "adminProductView",
                                component: AdminProductPage
                            }
                        ]
                    }
                ]

            }
        ]
    },
    { path: '*', component: vCatalog},
]

export default new VueRouter({
    mode: 'history',
    routes
})