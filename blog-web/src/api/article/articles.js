/**
 * Created by SNOW on 2018.01.25.
 */
import http from '@/api/util/http'

export const loadArticles = () => http.get('/article')

export const loadArticlesPage = (page, size) => http.get('/article', page, size)

export const loadUserArticles = (userId) => http.get('/article/user/' + userId)

export const loadUserArticlesPage = (userId, page, size) => http.get('/article/' + userId, page, size)
