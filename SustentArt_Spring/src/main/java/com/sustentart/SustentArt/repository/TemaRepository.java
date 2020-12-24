package com.sustentart.SustentArt.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sustentart.SustentArt.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	
	//Criando busca dos "método - Conteudo" 
	public List <Tema> findAllByConteudoContainingIgnoreCase (String conteudo);
	
	
	//Criando busca dos "método - DataHora"
	public List<Tema> findAllByDataHora(Date datahora);
	
}
