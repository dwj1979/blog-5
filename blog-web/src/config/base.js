/**
 * Created by SNOW on 2018.01.24.
 */
exports.install = function (Vue, options) {
  Vue.prototype.host = 'http://192.168.65.67:9999/'
  Vue.prototype.fileBase = Vue.prototype.host + 'file/'
}
