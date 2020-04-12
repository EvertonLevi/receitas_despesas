package com.webservice.msi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

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
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "lancamento_idlancamento", referencedColumnName = "id")
  private LancamentoEntity lancamento_idlancamento;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "conta_idconta", referencedColumnName = "id")
  private ContaEntity conta_idconta;

  public UsuarioEntity() {

  }

  public UsuarioEntity(int id, String nome, String email) {
    this.id = id;
    this.nome = nome;
    this.email = email;
  }

  public UsuarioEntity(int id, String nome, 
  String email, String senha,
   LancamentoEntity lancamento_idlancamento,
    ContaEntity conta_idconta) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.lancamento_idlancamento = lancamento_idlancamento;
    this.conta_idconta = conta_idconta;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
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

  public LancamentoEntity getIdLancamentoUsuario() {
    return this.lancamento_idlancamento;
  }

  public void setIdLancamentoUsuario(LancamentoEntity lancamento_idlancamento) {
    this.lancamento_idlancamento = lancamento_idlancamento;
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