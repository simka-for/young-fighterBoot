const state = {
    products: []
}
const getters = {
    PRODUCTS(state){
        return state.products;
    }
}
const actions = {
    async loadAllProducts({commit}){
        await axios({
            url: `http://localhost:9000/`,
            method: 'GET'
        })
    }
}