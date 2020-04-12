package com.webservice.msi.repository;

import com.webservice.msi.model.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;

// repositório foi necessário apenas estender da interface JpaRepository do Spring Data. Esta interface possui métodos para as operações padrão de um CRUD.
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}