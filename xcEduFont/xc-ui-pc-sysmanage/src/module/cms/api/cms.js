import http from './../../../base/api/public'
import querystring from 'querystring'

let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;

export const page_list = (page, size, params) => {
  let query = querystring.stringify(params);
  return http.requestGet(apiUrl + '/cms/page/list/' + page + '/' + size + '/?' + query);
}

export const page_add = params =>{
  return http.requestPost(apiUrl + '/cms/page/add', params);
}

export const site_list = ()=>{
  return http.requestGet(apiUrl + '/cms/site/list');
}

export const template_list = () => {
  return http.requestGet(apiUrl + '/cms/template/list');
};

export const page_get = id =>{
  return http.requestQuickGet(apiUrl + "/cms/page/get/" + id);
}
export const page_edit = (id,params) =>{
  return http.requestPut(apiUrl + "/cms/page/edit/" + id, params);
}
export const page_del = id =>{
  return http.requestDelete(apiUrl + "/cms/page/del/" + id);
}
