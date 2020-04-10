package com.webservice.msi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.micrometer.core.lang.NonNull;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.TABLE)
 private int id;

 @NotNull
 @Size(max = 30)
 private String nome;

 @NotNull
 @Size(max = 50)
 private String email;

 @NotNull
 @Size(max = 50)
 private String senha;

 @NotNull
 @Size(min = 5, max = 5)
 private int idLancamento;

 @NotNull
 @Size(min = 5, max = 5)
 private int idConta;

 public UsuarioEntity() {

 }

 public UsuarioEntity(int id, String nome, String email, String senha, int idLancamento, int idConta) {
  this.id = id;
  this.nome = nome;
  this.email = email;
  this.senha = senha;
  this.idLancamento = idLancamento;
  this.idConta = idConta;
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

 public int getIdLancamento() {
  return this.idLancamento;
 }

 public void setIdLancamento(int idLancamento) {
  this.idLancamento = idLancamento;
 }

 public int getIdConta() {
  return this.idConta;
 }

 public void setIdConta(int idConta) {
  this.idConta = idConta;
 }

 public String toString() {
  return "{" + " id='" + getId() + "'" + ", name='" + getNome() + "'" + ", lastName='" + getSenha() + "'" + ", email='"
    + getEmail() + "'" + ", conta ='" + getIdConta() + "'" + "}";
 }

}