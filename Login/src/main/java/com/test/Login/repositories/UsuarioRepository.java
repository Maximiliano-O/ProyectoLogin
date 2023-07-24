package com.test.Login.repositories;

import com.test.Login.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends CrudRepository<com.test.Login.entities.UsuarioEntity, Long> {


    Optional<UsuarioEntity> findByCorreoUsuarioAndPasswordUsuario(String mail, String pass);


}