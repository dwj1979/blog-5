/**
 * Created by SNOW on 2018.01.23.
 */
import * as articleApi from '@/api/home/article'

// mutations names
const UPDATE_ARTICLES = 'UPDATE_ARTICLES'

// state
const state = {
}

// actions
const actions = {
  async getArticles ({commit}, args) {
    const result = await articleApi.getArticles(args)
    commit(UPDATE_ARTICLES, result.data.data)
  }
}

// mutations
const mutations = {
  UPDATE_ARTICLES (state, articles) {
    state.articles = articles
  }
}

export default {
  state,
  actions,
  mutations
}
