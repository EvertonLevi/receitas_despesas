package com.webservice.msi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lancamento")
public class LancamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(name = "data_de_lancamento")
  private LocalDateTime data_de_lancamento;

  @Column
  private String descricao;

  @NotNull
  @Column
  private Float valor;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private UsuarioEntity usuarioEntity;

  public LancamentoEntity() {

  }

  public LancamentoEntity(Long id, UsuarioEntity usuarioEntity, LocalDateTime data_de_lancamento,
      // ContaEntity idContaLancamento,
      String descricao, Float valor) {
    this.id = id;
    this.usuarioEntity = usuarioEntity;
    this.data_de_lancamento = data_de_lancamento;
    // this.idContaLancamento = idContaLancamento;
    this.descricao = descricao;
    this.valor = valor;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // public Date getDatalancamento() {
  // return this.data_de_lancamento;
  // }

  // public void setDataLancamento(Date data_de_lancamento) {
  // this.data_de_lancamento = data_de_lancamento;
  // }

  public UsuarioEntity getUsuarioEntity() {
    return this.usuarioEntity;
  }

  public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
    this.usuarioEntity = usuarioEntity;
  }

  // public ContaEntity getIdContaLancamento() {
  // return this.idContaLancamento;
  // }

  // public void setIdContaLancamento(ContaEntity idContaLancamento) {
  // this.idContaLancamento = idContaLancamento;
  // }

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

}