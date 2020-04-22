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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
// @JoinColumn(name = "usuario") no Usuario Entity

@Entity
@Table(name = "lancamento")
@JsonIgnoreProperties({ "nome", "email", "senha", "conta_idConta", "lancamento" })
public class LancamentoEntity {

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

  @ManyToOne
  private UsuarioEntity usuario;

  public UsuarioEntity getUsuarioEntity() {
    return this.usuario;
  }

  public void setUsuarioEntity(UsuarioEntity ue) {
    this.usuario = ue;
  }

  public LancamentoEntity(UsuarioEntity ueId) {
    this.usuario = ueId;
  }

  public LancamentoEntity() {

  }

  public LancamentoEntity(Long id, UsuarioEntity usuario, LocalDateTime data_de_lancamento, String descricao,
      Float valor) {
    this.id = id;
    this.usuario = usuario;
    this.data_de_lancamento = data_de_lancamento;
    this.descricao = descricao;
    this.valor = valor;
  }

  // @JsonIgnoreProperties({ "nome", "email", "conta_idconta", "id" })

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