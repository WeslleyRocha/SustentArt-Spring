package com.sustentart.SustentArt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity //entidade de relacionamento
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id //Determinando a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotNull //campo não poderá ficar vazio
	@Size(min = 1, max = 50)
	private String titulo;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String regiao;
	
	private Date data;
	
	private String imagem;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String material;
	
	private boolean tipo_presenca;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isTipo_presenca() {
		return tipo_presenca;
	}

	public void setTipo_presenca(boolean tipo_presenca) {
		this.tipo_presenca = tipo_presenca;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
