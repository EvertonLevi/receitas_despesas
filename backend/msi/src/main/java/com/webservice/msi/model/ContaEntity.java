package com.webservice.msi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conta")
public class ContaEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Size(max = 255)
 @Column
 private String descricao;

 // @OneToOne(fetch = FetchType.LAZY,
 // optional = false)
 // @JoinColumn(name = "id", 
 // nullable = false)
 // private UsuarioEntity usuario;

 public ContaEntity() {
 }
 public ContaEntity(Long id) {
  this.id = id;
 }

 public ContaEntity(Long id, String descricao) {
  this.id = id;
  this.descricao = descricao;
 }

 public Long getId() {
  return this.id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getDescricao() {
  return this.descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }
}