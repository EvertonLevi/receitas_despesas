package com.webservice.msi.dto;

import java.util.stream.Collectors;

import com.webservice.msi.model.UsuarioEntity;

import antlr.collections.List;

public class UsuarioDTO {
 private Long id;

 public UsuarioDTO(UsuarioEntity usuarioEntity) {
  this.id = usuarioEntity.getId();
 }

 public UsuarioEntity transformObj() {
  return new UsuarioEntity(id);
 }

 // public static java.util.List<UsuarioDTO> converter(java.util.List<UsuarioEntity> usuarList) {
 //  return usuarList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
 // }
}