import http from './../../../base/api/public'
import querystring from 'querystring'

let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;

export const page_list = (page, size, params) => {
  let query = querystring.stringify(params);
  return http.requestGet(apiUrl + '/cms/page/list/' + page + '/' + size + '/?' + query);
}

export const page_add = params =>{
  return htts.requestPost(apiUrl + '/cms/page/add', params);
}
