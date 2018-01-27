import Vue from 'vue'
import VueRouter from 'vue-router'
import VueVisible from 'vue-visible'
import axios from 'axios'

import App from './App.vue'
import routes from './router'
import store from './store'

import base from '@/config/base'
Vue.use(base)

Vue.config.productionTip = false
Vue.use(VueVisible)
const router = new VueRouter({
  routes: routes
})

/* eslint-disable no-new */
const vm = new Vue({
  router,
  store,
  components: {App},
  template: '<App/>'
})
axios.defaults.baseURL = vm.host
axios.defaults.fileUrl = vm.fileBase
vm.$mount('#app')
