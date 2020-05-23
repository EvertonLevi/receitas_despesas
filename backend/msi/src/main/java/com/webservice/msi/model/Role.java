// package com.webservice.msi.model;

// import java.util.List;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.ManyToMany;

// import org.springframework.security.core.GrantedAuthority;

// @Entity
// public class Role implements GrantedAuthority {

//  @Id
//  private String nomeRole;

//  @ManyToMany(mappedBy = "roles")
//  private List<UsuarioEntity> usuarios;

//  public String getNomeRole() {
//   return nomeRole;
//  }

//  public void setNomeRole(String nomeRole) {
//   this.nomeRole = nomeRole;
//  }

//  public List<UsuarioEntity> getUsuarios() {
//   return usuarios;
//  }

//  public void setUsuarios(List<UsuarioEntity> usuarios) {
//   this.usuarios = usuarios;
//  }

//  @Override
//  public String getAuthority() {
//   return this.nomeRole;
//  }

// }