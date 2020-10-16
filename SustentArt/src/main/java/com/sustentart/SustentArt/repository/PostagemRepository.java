package com.sustentart.SustentArt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentart.SustentArt.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	public List<Postagem> findAllByRegiaoContainingIgnoreCase(String regiao);
	public List<Postagem> findAllByDataBetween (Date dataInicio, Date dataFim );
}
