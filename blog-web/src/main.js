import Vue from 'vue'
import VueRouter from 'vue-router'
import VueVisible from 'vue-visible'
import axios from 'axios'

import App from './App.vue'
import routes from './router'
import store from './store'

import elementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

import 'highlight.js/styles/googlecode.css' // 样式文件
import base from '@/config/base'
import commonUtil from '@/util/common'
import VueHighlightJS from 'vue-highlightjs'
import snowDialog from '@/component/common/snowDialog'
import snowUpload from '@/component/common/snowUpload'

Vue.use(elementUI)
Vue.use(mavonEditor)
Vue.use(VueVisible)
Vue.use(VueHighlightJS)

Vue.use(snowDialog)
Vue.use(snowUpload)

Vue.use(base)
Vue.use(commonUtil)
Vue.config.productionTip = false
const router = new VueRouter({
  mode: 'history',
  routes: routes
})

/* eslint-disable no-new */
const vm = new Vue({
  router,
  store,
  components: {App, snowDialog, snowUpload},
  template: '<App/>'
})
axios.defaults.baseURL = vm.host
axios.defaults.fileUrl = vm.fileBase
vm.$mount('#app')
