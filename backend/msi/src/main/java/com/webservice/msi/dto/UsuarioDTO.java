package com.webservice.msi.dto;

import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;

public class UsuarioDTO {
 private Long usuario_id;

 public UsuarioDTO(LancamentoEntity ue) {
  this.usuario_id = ue.getUsuarioEntity().getId();
 }

 // public UsuarioEntity transformObj() {
 //  return new UsuarioEntity(usuario_id);
 // }

 public Long getUsuario_id() {
  return this.usuario_id;
 }

 public void setUsuario_id(Long usuario_id) {
  this.usuario_id = usuario_id;
 }
}