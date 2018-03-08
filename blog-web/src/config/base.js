/**
 * Created by SNOW on 2018.01.24.
 */
exports.install = function (Vue, options) {
  Vue.prototype.host = 'http://localhost:9999/blog/'
  Vue.prototype.fileRelative = 'file/'
  Vue.prototype.fileBase = Vue.prototype.host + Vue.prototype.fileRelative
}
