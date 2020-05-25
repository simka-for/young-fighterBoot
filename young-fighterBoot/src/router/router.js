import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductList from '../components/Product/ProductList.vue'
import AdminPage from "../components/adminPanel/AdminPage.vue";

Vue.use(VueRouter)

const routes = [
    { path: '/', component: ProductList},
    { path: '/admin', component: AdminPage},
    { path: '*', component: ProductList},


]

export default new VueRouter({
    mode: 'history',
    routes
})