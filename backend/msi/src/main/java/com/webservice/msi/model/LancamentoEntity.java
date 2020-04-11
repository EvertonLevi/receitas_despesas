package com.webservice.msi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

@Entity
@Table(name = "lancamento")
public class LancamentoEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private LocalDateTime dataLancamento;

 @ManyToOne
 private int idContaLancamento;

 private String descricao;

 @NotNull
 private Float valor;

 public LancamentoEntity() {

 }

 public LancamentoEntity(int id, 
 LocalDateTime dataLancamento,
 int idContaLancamento, String descricao, Float valor) {
  this.id = id;
  this.dataLancamento = dataLancamento;
  this.idContaLancamento = idContaLancamento;
  this.descricao = descricao;
  this.valor = valor;
 }

 public int getId(){
  return this.id;
 }
 public void setId(int id){
  this.id = id;
 }

 public LocalDateTime getDatalancamento(){
  return this.dataLancamento;
 }
 public void setDataLancamento(LocalDateTime dataLancamento){
  this.dataLancamento = dataLancamento;
 }

 public int getIdContaLancamento(){
  return this.idContaLancamento;
 }
 public void setIdContaLancamento(int idContaLancamento){
  this.idContaLancamento = idContaLancamento;
 }

 public String getDescricao(){
  return this.descricao;
 }
 public void setDescricao(String descricao){
  this.descricao = descricao;
 }
 public Float getValor(){
  return this.valor;
 }
 public void setValor(Float valor){
  this.valor = valor;
 }



}