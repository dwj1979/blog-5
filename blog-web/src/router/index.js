import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home/home'

Vue.use(Router)

const routers = [
  {
    path: '/',
    name: 'home',
    component: home
  }
]

export default routers
