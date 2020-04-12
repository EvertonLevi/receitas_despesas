package com.webservice.msi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conta")
public class ContaEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column
 private int id;

 @Size(max = 255)
 @Column
 private String descricao;

 public ContaEntity() {
 }

 public ContaEntity(int id, String descricao) {
  this.id = id;
  this.descricao = descricao;
 }

 public int getId() {
  return this.id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getDescricao() {
  return this.descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }
}