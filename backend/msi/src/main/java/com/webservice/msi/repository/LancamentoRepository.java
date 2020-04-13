package com.webservice.msi.repository;

import com.webservice.msi.model.LancamentoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {

}