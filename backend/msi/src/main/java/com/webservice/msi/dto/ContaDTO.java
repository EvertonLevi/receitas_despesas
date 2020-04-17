package com.webservice.msi.dto;

import com.webservice.msi.model.ContaEntity;

public class ContaDTO {

 private Long id;

 public ContaEntity transformObjConta() {
  return new ContaEntity(id);
 }

 public Long getId() {
  return this.id;
 }

 public void serId(Long id) {
  this.id = id;
 }
}