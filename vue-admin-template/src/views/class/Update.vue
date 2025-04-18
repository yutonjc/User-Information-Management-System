<template>
  <div style="width: 600px">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px">
      <el-form-item label="id" prop="id">
        <el-input v-model="form.id" />
      </el-form-item>
      <el-form-item label="名字" prop="name">
        <el-input v-model="form.className" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">提交</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Update',
  data() {
    return {
      form: {
        id: '',
        className: '',
      },
      rules: {
        className: [
          { required: true, message: '班级名不能为空', trigger: 'blur' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ]

      }
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8080/myclass/query2?id=' + this.$route.query.id).then(function(resp) {
      _this.form = resp.data
    })
  },
  methods: {
    onSubmit(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(_this.form)
          axios.put('http://localhost:8080/myclass/update', this.form).then(function(resp) {
            if (resp.data > 0) {
              _this.$alert(_this.form.className + '已被修改！', '提示', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('../class')
                }
              })
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
