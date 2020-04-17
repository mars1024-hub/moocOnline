import Home from '@/module/home/page/home.vue';
import page_list from '@/module/cms/page/page_list.vue'
import page_add from '@/module/cms/page/page_add.vue'

export default [{
  path: '/',
  component: Home,
  name: 'CMS',
  hidden: false,
  children: [
    {path: '/cms/page/list', name: '数据查询页面', component: page_list, hidden: false},
    {path: '/cms/page/add', name: '新增页面', component: page_add, hidden: true},
  ]
}
]