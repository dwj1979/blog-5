/**
 * Created by SNOW on 2018.01.23.
 */
import Vue from 'vue'
import Vuex from 'vuex'
import homeModuleGroup from './modules/home'
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    ...homeModuleGroup
  }
})
