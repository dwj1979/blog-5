import Vue from 'vue'
import Router from 'vue-router'
import article from './article'
import write from './write'
import index from '@/component/index'
Vue.use(Router)

const routers = [
  {
    path: '/',
    component: index,
    redirect: '/home',
    children: [
      article,
      write
    ]
  }
]

export default routers
