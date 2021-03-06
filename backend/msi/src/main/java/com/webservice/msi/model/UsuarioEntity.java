package com.webservice.msi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

// UserDetails
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable, UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(max = 30)
  private String nome;

  @NotBlank(message = "Por favor, insira um e-mail")
  @Size(max = 50)
  private String email;

  @Size(max = 50)
  private String senha;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  private ContaEntity conta;

  @OneToMany(mappedBy = "usuario", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
  private List<LancamentoEntity> lancamentos;

  // @ManyToMany
  // @JoinTable(
  // name = "usuarios_roles",
  // joinColumns = @JoinColumn(
  // name = "id", referencedColumnName = "email"),
  // inverseJoinColumns = @JoinColumn(
  // name = "id", referencedColumnName = "nomeRole"))
  // private List<Role> roles;

  public UsuarioEntity() {

  }

  public UsuarioEntity(Long id) {
    this.id = id;
  }

  public UsuarioEntity(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }

  public UsuarioEntity(String nome, String email, String senha, ContaEntity contaEntity) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.conta = contaEntity;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // public List<Role> getRole() {
  // return roles;
  // }

  // public void setRole(List<Role> roles) {
  // this.roles = roles;
  // }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public List<LancamentoEntity> getLancamento() {
    return lancamentos;
  }

  public void setLancamento(List<LancamentoEntity> lancamentos) {
    this.lancamentos = lancamentos;
  }

  public ContaEntity getIdContaUsuario() {
    return this.conta;
  }

  public void setIdContaUsuario(ContaEntity contaEntity) {
    this.conta = contaEntity;
  }

  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getNome() + "'" + ", lastName='" + getSenha() + "'"
        + ", email='" + getEmail() + "'" + ", conta ='" + getIdContaUsuario() + "'" + "}";
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    // this.email por meu front validar por email
    return this.email;
  }

  // TODO métodos de conta expirada, bloqueado etc...
  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

}