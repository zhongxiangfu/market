import axios from '@/plugins/axios'
export default {
    // 查询预定列表信息
    queryBookList(data){
        return axios({
            url: '/sxs/resignation/findProcessUserById',
            method: 'get',
            params: data
        })
    },
}