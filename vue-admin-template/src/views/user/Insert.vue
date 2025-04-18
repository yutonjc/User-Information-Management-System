<template>
  <div style="width: 600px">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px">
      <el-form-item label="id" prop="id">
        <el-input v-model="form.id"></el-input>
      </el-form-item>
      <el-form-item label="名字" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="form.age"></el-input>
      </el-form-item>
      <el-form-item label="班级" prop="classId">
        <el-input v-model="form.classId"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email"></el-input>
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
  name: 'Insert',
  data() {
    return {
      form: {
        id: '',
        name: '',
        age: '',
        classId: '',
        email: ''
      },
      rules: {
        name: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        age: [
          { required: true, message: '年龄不能为空', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '邮箱不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    onSubmit(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(_this.form)
          axios.post('http://localhost:8080/insert3', this.form).then(function(resp) {
            if (resp.data > 0) {
              _this.$alert(_this.form.name + '已添加成功！', '提示', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('../user')
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
