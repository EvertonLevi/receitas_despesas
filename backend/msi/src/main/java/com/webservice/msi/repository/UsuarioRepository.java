package com.webservice.msi.repository;

import java.util.Optional;

import com.webservice.msi.model.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
 UsuarioEntity findByEmail(String email);
}