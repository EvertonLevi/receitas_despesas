package com.webservice.msi.repository;

import com.webservice.msi.model.ContaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}