<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 1000px"
      :header-cell-style="{'text-align':'center'}"
    >
      <el-table-column
        fixed
        prop="id"
        label="编号"
        width="150"
      />
      <el-table-column
        prop="name"
        label="用户名"
        width="120"/>
      <el-table-column
        prop="age"
        label="年龄"
        width="120">
      </el-table-column>
      <el-table-column
        prop="classId"
        label="班级"
        width="120">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱"
        width="150">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pageSize"
      :total="total"
      @current-change="ChangePage"
    />
    <el-row>
      <router-link to="/user/insert">
        <el-button type="primary">插入学生数据</el-button>
      </router-link>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Index',
  data() {
    return {
      tableData: [],
      pageSize: 0,
      total: 0,
      currentPage: 0
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8080/findByPage/1/5').then(function(resp) {
      console.log(resp.data)
      _this.tableData = resp.data.records
      _this.pageSize = resp.data.size
      _this.total = resp.data.total
      _this.currentPage = resp.data.current
    })
  },
  methods: {
    ChangePage(currentPage) {
      const _this = this
      axios.get('http://localhost:8080/findByPage/' + currentPage + '/5').then(function(resp) {
        _this.tableData = resp.data.records
        _this.pageSize = resp.data.size
        _this.total = resp.data.total
        _this.currentPage = resp.data.current
      })
    },
    handleEdit(row) {
      this.$router.push('/user/update?id=' + row.id)
    },
    handleDelete(row) {
      const _this = this
      this.$confirm('此操作将永久删除' + row.name + '账号信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8080/delete4/' + row.id).then(function(resp) {
          if (resp.data > 0) {
            _this.$alert(row.name + '已被删除！', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                location.reload()
              }
            })
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
