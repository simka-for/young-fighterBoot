import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersist from "vuex-persist";
import Cart from './modules/cart.js'

Vue.use(Vuex)

const vuexSessionStorage = new VuexPersist({
    key: "vuex",
    storage: window.sessionStorage,
});

const state = {};

const getters = {};

const mutation = {};

const actions = {};

export default new Vuex.Store({
    plugins: [vuexSessionStorage.plugin],
    modules: {
        Cart
    },
    state,
    getters,
    mutation,
    actions,
    strict: true
})