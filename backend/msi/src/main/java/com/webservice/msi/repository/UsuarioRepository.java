package com.webservice.msi.repository;

import javax.persistence.EntityManager;

import com.webservice.msi.model.ContaEntity;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositório foi necessário apenas estender da interface JpaRepository do Spring Data. Esta interface possui métodos para as operações padrão de um CRUD.
@Repository
public interface UsuarioRepository 
extends JpaRepository<UsuarioEntity, Long> {

}