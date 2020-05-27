import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import vuetify from './plugins/vuetify';
import store from './vuex/store'

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  vuetify,
  store,
  render: a => a(App)
})
