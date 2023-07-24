package com.test.Login.services;

import com.test.Login.entities.UsuarioEntity;
import com.test.Login.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<UsuarioEntity> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> obtenerPorID(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioEntity guardar(UsuarioEntity usuarioEntityNuevo) {
        return usuarioRepository.save(usuarioEntityNuevo);
    }

    public void eliminarPorID(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity authenticate(String mail, String pass){
        System.out.println("authenticate request: ");
        return usuarioRepository.findByCorreoUsuarioAndPasswordUsuario(mail, pass).orElse(null);
    }
}
