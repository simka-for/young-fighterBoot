import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import vuetify from './plugins/vuetify';

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  vuetify,
  render: a => a(App)
})
