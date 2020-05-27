const state = {
    cart: []
}
const getters = {
    CART(state){
        return state.cart;
    }
}
const mutations = {
    SET_CART: (state, product) => {
        state.cart.push(product)
    },
    REMOVE_FROM_CART: (state, index) => {
        state.cart.splice(index,1)
    }
}

const actions = {
    ADD_TO_CART({commit}, product) {
        commit('SET_CART', product);
    },
    DELETE_FROM_CART({commit}, index){
        commit('REMOVE_FROM_CART', index)
    }
}

export default {
    state,
    getters,
    mutations,
    actions
}