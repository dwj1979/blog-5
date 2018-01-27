/**
 * Created by SNOW on 2018.01.25.
 */
import http from '@/api/http'

export const getArticles = (param) => http.setAxiosGetPromise('home/article/', param)
