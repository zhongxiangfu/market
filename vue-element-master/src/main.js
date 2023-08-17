import Vue from 'vue'
import ElementUI from 'element-ui'
// import '../theme/index.css'
import 'element-ui/lib/theme-default/index.css'
import App from './App.vue'
import VueRouter from 'vue-router'
import routerMap from './router.js'

Vue.use(VueRouter);
Vue.use(ElementUI);

import axios from 'axios';
Vue.prototype.$axios = axios;

import moment from "moment";
Vue.prototype.$moment = moment;//时间格式化

const router = new VueRouter({routes: routerMap})

const app = new Vue({
  router
}).$mount('#app');
