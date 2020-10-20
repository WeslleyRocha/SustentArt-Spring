package com.sustentart.SustentArt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sustentart.SustentArt.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SustentArt")
				.description("A SustentArt vai criar uma comunidade de pessoas interessadas em dar uma nova "
						+ "utilidade para itens que muitas vezes são considerados como lixo e, ainda, ensinará, "
						+ "por meio de oficinas e cursos, pessoas interessadas em aprender novas habilidades "
						+ "(seja com hobby ou como nova forma de empreender), usando os itens à disposição na SustentArt como matéria-prima.")
				.version("1.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact() {
		return new Contact("Equipe SustentArt: Henrique Seiji, Josimar Pereira, Vanessa Marchetti, Weslley Rocha",
				"https://github.com/WeslleyRocha/Projeto-Integrador-Generation",
				"Alunos da 9ª Turma do Bootcamp Generation Brasil");
	}
}
