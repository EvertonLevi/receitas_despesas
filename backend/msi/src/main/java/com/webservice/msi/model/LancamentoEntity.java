package com.webservice.msi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@Entity
@Table(name = "lancamento")
public class LancamentoEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(name = "data_de_lancamento")
  private LocalDateTime data_de_lancamento;

  @Column
  private String descricao;

  @Column
  private Float valor;

  // @JoinColumn(name = "usuario_id")
  @ManyToOne( cascade =  CascadeType.ALL, optional = false)
  private UsuarioEntity usuario;

  public LancamentoEntity() {

  }

  public LancamentoEntity(  
    UsuarioEntity usuario, 
  LocalDateTime data_de_lancamento, 
  String descricao, Float valor) { 
    this.usuario = usuario;
    this.data_de_lancamento = data_de_lancamento;
    this.descricao = descricao;
    this.valor = valor;
  }

  public UsuarioEntity getUsuarioEntity() {
    return usuario;
  }

  public void setUsuarioEntity(UsuarioEntity ue) {
    this.usuario = ue;
  }

  public LancamentoEntity(UsuarioEntity ueId) {
    this.usuario = ueId;
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

  public Float getValor() {
    return this.valor;
  }

  public void setValor(Float valor) {
    this.valor = valor;
  }

  public LocalDateTime getData_de_lancamento() {
    return this.data_de_lancamento;
  }

  public void setData_de_lancamento(LocalDateTime data_de_lancamento) {
    this.data_de_lancamento = data_de_lancamento;
  }

}