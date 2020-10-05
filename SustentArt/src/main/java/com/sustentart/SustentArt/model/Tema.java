package com.sustentart.SustentArt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity //entidade de relacionamento
@Table(name = "tb_tema") //criando a tabela tema
public class Tema {
	
	
	@Id //identifica o atributo como ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull //campo não poderá ficar vazio
	@Size(min=5, max=200)
	private String conteudo;
	
	
	@Temporal(TemporalType.TIMESTAMP) //gera a data e hora automaticamente
	private Date dataHora = new java.sql.Date(System.currentTimeMillis());
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}