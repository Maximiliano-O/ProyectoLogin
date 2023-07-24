<template>
<div class="login-page">
    <div class="form">
      <form class="login-form">
        <input type="text" v-model="text" placeholder="Correo"/>
        <input type="password" v-model="password" placeholder="Contraseña"/>
        <button @click="login">Ingresar</button>
        <p class="message">¿No estás registrado? <a href="/add">Contactar administración</a></p>
      </form>
    </div>
  </div>
</template>

<style> 
@import '../assets/Login.css' 
</style>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      text: '',
      password: ''
    };
  },
  methods: {
    async login() {
      let json = {
        correoUsuario: this.text,
        passwordUsuario: this.password
      };
      try {
        const response = await axios.post('http://localhost:8080/authentication', json);
        console.log(response.data);
        window.location.href = "http://localhost:5173/profile"; 
      } catch (error) {
        console.error(error);
      }
    }
  }
}
</script>