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
        prop="className"
        label="班級"
        width="120"
      />

      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)"
          >编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row>
      <router-link to="/class/insert">
        <el-button type="primary">添加班级数据</el-button>
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
      className: ''
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8080/myclass/query').then(function(resp) {
      console.log(resp.data)
      _this.tableData = resp.data
      _this.className = resp.data.className
    })
  },
  methods: {
    handleEdit(row) {
      this.$router.push('/class/update?id=' + row.id)
    },
    handleDelete(row) {
      const _this = this
      this.$confirm('此操作将永久删除' + row.className + '账号信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8080/myclass/delete/' + row.id).then(function(resp) {
          if (resp.data > 0) {
            _this.$alert(row.className + '已被删除！', '提示', {
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
