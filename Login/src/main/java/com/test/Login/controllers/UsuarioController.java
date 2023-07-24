package com.test.Login.controllers;


import com.test.Login.entities.UsuarioEntity;
import com.test.Login.services.UsuarioService;
import com.test.Login.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/Usuario/")
    public UsuarioEntity guardar(@RequestBody UsuarioEntity usuarioNuevo) {
        return usuarioService.guardar(usuarioNuevo);
    }

    @GetMapping("/ListaUsuarios/")
    public Iterable<UsuarioEntity> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/Usuario/{id}")
    public Optional<UsuarioEntity> obtenerPorID(@PathVariable Long id) {
        return usuarioService.obtenerPorID(id);
    }

    @DeleteMapping("/Usuario/{id}")
    public void eliminarPorID(@PathVariable Long id) {
        usuarioService.eliminarPorID(id);
    }

    @PostMapping("/authentication")
    public String login(@RequestBody UsuarioEntity usuario){
        System.out.println("login request: "+ usuario);
        UsuarioEntity authenticated = usuarioService.authenticate(usuario.getCorreoUsuario(), usuario.getPasswordUsuario());
        if(authenticated != null){
            System.out.println("logged: "+ authenticated);
            return "home_interno_page";
        }
        else{
            return "failed_log_page";
        }
    }
}