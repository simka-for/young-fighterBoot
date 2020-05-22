import Vue from 'vue'
import App from './App.vue'
import VueResource from "vue-resource";

Vue.config.productionTip = false

Vue.use(VueResource)

new Vue({
  el: '#app',
  render: a => a(App)

})
