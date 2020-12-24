package com.sustentart.SustentArt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sustentart.SustentArt.model.Tema;
import com.sustentart.SustentArt.repository.TemaRepository;



@RestController
@CrossOrigin("*")           // Da acesso todal dos conteudos
@RequestMapping("/tema")   //Definindo URL para busca
public class TemaController {

	
	
	//Interligação do "Repository" com os metodos abaixo (Get,Post,Delete) e permite ser acessado pelo controller 
	
	@Autowired
	private TemaRepository repository;
	
	

	//Metodo de busca de dados no bando de dados!
	
	@GetMapping  
	public ResponseEntity<List<Tema>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	
	
	//Método de busca por "ID"
	
	@GetMapping("/{id}") 
	public ResponseEntity<Tema> getById (@PathVariable long id)
	{
		return repository.findById(id).map (resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	//Método de busca por "conteudo"
	
	@GetMapping("/conteudo/{conteudo}") 
	public ResponseEntity<List<Tema>> getByConteudo (@PathVariable String conteudo)
	{
		return ResponseEntity.ok(repository.findAllByConteudoContainingIgnoreCase(conteudo));
	}
	
	
	
	//Método de busca por "data hora"
	
	@GetMapping("/datahora/{datahora}")  
	public ResponseEntity<List<Tema>> getByDataHora (@PathVariable Date datahora)
	{
		return ResponseEntity.ok(repository.findAllByDataHora(datahora));
	}
	
	
	
	
	//Método postagem de dados!
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	
	
	//Método atualização de dados!
	
	@PutMapping 
	public ResponseEntity<Tema> put (@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	
	//Método de deletar os dados por "ID"
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
	
	
}
