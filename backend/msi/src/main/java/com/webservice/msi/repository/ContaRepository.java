package com.webservice.msi.repository;

import com.webservice.msi.model.ContaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}