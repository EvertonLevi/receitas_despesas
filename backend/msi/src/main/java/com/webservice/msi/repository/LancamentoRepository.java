package com.webservice.msi.repository;

import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;
import java.util.List;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository 
extends JpaRepository<LancamentoEntity, Long> {
 // List<LancamentoEntity> findByUsuarioEntityId(Long usuarioId);
 // Optional<LancamentoEntity> findByIdAndUsuarioEntityId(Long id, Long usuarioId);
}