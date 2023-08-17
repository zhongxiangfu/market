<template>
  <div class="testProject">
    <div class="function">
      <el-row>
        <el-col :span="4">
          <div class="grid-content bg-purple">
            <el-input
              placeholder="请输入酒店名称"
              v-model="input">
            </el-input>
          </div>
        </el-col>
        <el-col :span="20">
          <el-button type="primary" @click.native="onNewClick">新增预定</el-button>
          <el-button type="primary" @click.native="queryBookList" style="margin-right: 5px">查询</el-button>
        </el-col>
      </el-row>
    </div>
    <div id="table">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%">
        <el-table-column type="selection" width="50"></el-table-column>
        <el-table-column
          prop="bookNo"
          label="预定编号"
          align="center"
          width=150>
        </el-table-column>
        <el-table-column
          prop="hotelName"
          label="酒店名称"
          align="center"
          width=250>
        </el-table-column>
        <el-table-column
          prop="roomType"
          label="房间类型"
          align="center"
          :formatter="roomTypeFormatter"
          width=150>
        </el-table-column>
        <el-table-column
          prop="roomPrice"
          label="房间价钱"
          align="center"
          width=150>
        </el-table-column>
        <el-table-column
          prop="bookDateStart"
          label="预定开始日期"
          align="center"
          width=180>
        </el-table-column>
        <el-table-column
          prop="bookDateEnd"
          align="center"
          label="预定结束日期">
        </el-table-column>

        <el-table-column
          :context="_self"
          inline-template
          label="操作"
          width=120>
          <span>
            <el-button @click="onDelClick($index)" type="text" size="small">删除</el-button>
          </span>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog title="新增预定" v-model="isDialogShow" size="small">
      <el-form :model="form">
       <el-form-item label="酒店名称" :label-width="formLabelWidth">
         <el-select v-model="form.hotelNo" placeholder="请选择酒店">
           <el-option v-for="item in hotelList" :key="item.hotelNo" :label="item.hotelName" :value="item.hotelNo"/>
         </el-select>
       </el-form-item>
        <el-form-item label="房间类型" :label-width="formLabelWidth">
          <el-select v-model="form.roomType" placeholder="请选择房间类型">
            <el-option key="D" label="大床房" value="D"></el-option>
            <el-option key="B" label="标准间" value="B"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="预定开始日期" :label-width="formLabelWidth">
          <el-date-picker
              v-model="form.bookDateStart"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预定结束日期" :label-width="formLabelWidth">
          <el-date-picker
              v-model="form.bookDateEnd"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
     </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="isDialogShow = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import axios from 'axios'
  import Qs from 'qs'
  export default {
    data(){
      return {
        input: '',
        dialogTitle: '',
        isDialogShow: false,
        tableData: [{"3333":"11112","44444":"22223"}],
        form: {
          hotelNo: '',
          roomType: '',
          bookDateStart: '',
          bookDateEnd: '',
       },
        hotelList:[],
       formLabelWidth: '120px'

      }

    },
    methods: {

      roomTypeFormatter(row, column, value){
        if(value){
          if(value === "D"){
            return "大床房"
          }else{
            return "标准间"
          }
        }else{
          return ""
        }
      },

      /**
       * 提交
       */
      submit() {
        const _this = this
        const param = {}
        const bookInfo = {
          hotelNo: _this.form.hotelNo,
          roomType: _this.form.roomType,
          bookDateStart: this.$moment(_this.form.bookDateStart).format('YYYYMMDD'),
          bookDateEnd: this.$moment(_this.form.bookDateEnd).format('YYYYMMDD'),
        }
        axios({
          header: {
            "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
          },
          method: "post",
          url: "http://localhost:11102/book/save",
          data: Qs.stringify(bookInfo),//在传参之前先用qs.stringify转化一下格式
        }).then((response) => {
          _this.$message.success("新增成功");
          _this.isDialogShow = false
          _this.queryBookList()
        }).catch((err) => {
          console.log(err)
        })
      },

      /**
       * 查询酒店预定列表
       */
      queryBookList() {
        const _this = this
        axios.get("http://localhost:11102/book/queryBookList")
            .then(function (response) {
              console.log("000000000", response);
              console.log("this.tableData====", _this.tableData)
              _this.tableData = response.data
            }, function (err) {
              console.log(err);
            })
      },

      /**
       * 查询酒店信息
       */
      queryHotelInfo() {
        const _this = this
        axios.get("http://localhost:11102/book/queryHotelList")
            .then(function (response) {
              console.log("000000000hotelList", response);
              _this.hotelList = response.data
              console.log("_this.hotelList====", _this.hotelList)
            }, function (err) {
              console.log(err);
            })
      },

      /**
       * 删除
       * @param index
       */
      onDelClick: function (index) {
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 此处应为异步请求服务器进行数据库的操作
          console.log("this.tableData=====", this.tableData)
          //this.tableData.splice(index,1);
          let bookNo = ""
          this.tableData.forEach((item, index1) => {
            if (index1 === index) {
              bookNo = item.bookNo
            }
          })
          if (!bookNo) {
            this.$message.error("预定编号为空");
            return
          }
          this.deleteBook(bookNo)
        }).catch(() => {
        });
      },

      /**
       * 新增预定
       */
      onNewClick: function () {
        this.isDialogShow = true;
      },

      deleteBook(bookNo) {
        const _this = this
        const param = {
          bookNo: bookNo,
        }
        axios({
          header: {
            "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
          },
          method: "post",
          url: "http://localhost:11102/book/delete",
          data: Qs.stringify(param),//在传参之前先用qs.stringify转化一下格式
        }).then((response) => {
          _this.$message.success("删除成功");
          _this.queryBookList()
        }).catch((err) => {
          console.log(err)
        })
      },
    },
    mounted() {
      this.queryBookList()
      this.queryHotelInfo()
    }
  }
</script>

<style media="screen">
  .function{
    margin-bottom:10px;
  }
  .function button{
    float:right;
  }
</style>
