package com.webservice.msi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  private int idLancamentoUsuario;

  private int idContaUsuario;

  public UsuarioEntity() {

  }

  public UsuarioEntity(int id, String nome, String email, String senha, int idLancamentoUsuario, int idContaUsuario) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.idLancamentoUsuario = idLancamentoUsuario;
    this.idContaUsuario = idContaUsuario;
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

  public int getIdLancamentoUsuario() {
    return this.idLancamentoUsuario;
  }

  public void setIdLancamentoUsuario(int idLancamentoUsuario) {
    this.idLancamentoUsuario = idLancamentoUsuario;
  }

  public int getIdContaUsuario() {
    return this.idContaUsuario;
  }

  public void setIdContaUsuario(int idContaUsuario) {
    this.idContaUsuario = idContaUsuario;
  }

  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getNome() + "'" + ", lastName='" + getSenha() + "'"
        + ", email='" + getEmail() + "'" + ", conta ='" + getIdContaUsuario() + "'" + "}";
  }

}