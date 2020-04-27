package com.webservice.msi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 30)
  private String nome;

  @NotNull
  @NotBlank(message = "Por favor, insira um e-mail")
  @Size(max = 50)
  private String email;

  @NotNull
  @Size(max = 50)
  private String senha;

  // @JoinColumn(name = "conta_id", nullable = false)
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  private ContaEntity conta;

  @OneToMany(
      mappedBy = "usuario"
      ,cascade = {CascadeType.ALL}
      // , fetch = FetchType.LAZY
      )
  private List<LancamentoEntity> lancamentos;

  public UsuarioEntity() {

  }

  public UsuarioEntity(Long id) {
    this.id = id;
  }

  public UsuarioEntity(String nome, String email, 
  String senha ) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
   }

  public UsuarioEntity(String nome, String email, 
  String senha, ContaEntity contaEntity) {
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

}