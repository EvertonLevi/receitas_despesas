package com.webservice.msi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @NotNull
  @Size(max = 30)
  @Column
  private String nome;

  @NotNull
  @NotBlank(message = "Por favor, insira um e-mail")
  @Size(max = 50)
  @Column
  private String email;

  @NotNull
  @Size(max = 50)
  @Column
  private String senha;



  
  @Column
  @OneToMany(
  mappedBy = "usuarioEntity", 
  cascade = CascadeType.ALL)
  private List<LancamentoEntity> lancamento;












  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuarioEntity")
  private ContaEntity conta_idconta;

  public UsuarioEntity() {

  }

  public UsuarioEntity(Long id, String nome, String email) {
    this.id = id;
    this.nome = nome;
    this.email = email;
  }

  // public UsuarioEntity(Long id, String nome, String email, ContaEntity
  // conta_idconta) {
  // this.id = id;
  // this.nome = nome;
  // this.email = email;
  // this.conta_idconta = conta_idconta;
  // }

  public UsuarioEntity(Long id, String nome, String email, String senha, ContaEntity conta_idconta) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.conta_idconta = conta_idconta;
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

  public List<LancamentoEntity> getIdLancamentoUsuario() {
    return this.lancamento;
  }

  public void setIdLancamentoUsuario(List<LancamentoEntity> lancamento) {
    this.lancamento = lancamento;
  }

  public ContaEntity getIdContaUsuario() {
    return this.conta_idconta;
  }

  public void setIdContaUsuario(ContaEntity conta_idconta) {
    this.conta_idconta = conta_idconta;
  }

  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getNome() + "'" + ", lastName='" + getSenha() + "'"
        + ", email='" + getEmail() + "'" + ", conta ='" + getIdContaUsuario() + "'" + "}";
  }

}