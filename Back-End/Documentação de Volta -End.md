<h1><b> :memo: Documentação Back-End :bookmark_tabs: </b></h1> 


 <h2> • Tabela Tema </h2>
 
|     ATRIBUTO                  |     TIPO               |
|-------------------------------|------------------------|
|     ID [Primary Key]          |     Bigint             |
|     Conteúdo                  |     Varchar(200)       |
|     Data e Hora               |     Datetime           |
|     Postagem [Foreign Key]    |     List<Postagem>     |
 
A tabela possuirá os atributos ID, os quais referem-se ao código de cada um dos conteúdos postados. Entre as possibilidades existentes, estão: doação e, caso positivo, de quais tipos de materiais, ou de disponibilização de oficinas presenciais, ou cursos online etc. Haverá, ainda, a lista de postagem da marcação <b>@OneToMany</b> (isto é, um tema pode receber várias postagens).

 
 <h2> •	Crud Tema</h2>

| MÉTODOS    |     END-POINTS                   |     DESCRIÇÃO                                                                  |
|---------------|------------------------------------|---------------------------------------------------------------------------|
|     GET       |     /tema                          |     Lista todos os temas existentes.                                      |
|     GET       |     /tema/ {id}                    |     Lista temas específicos por ID.                                       |
|     GET       |     /tema/conteudo/{conteudo}      |     Lista temas específicos de acordo com o   conteúdo.                   |
|     GET       |     /tema/dataehora/{dataehora}    |     Lista temas específicos de acordo com a data   e hora da postagem.    |
|     POST      |     /tema                          |     Insere dados na tabela.                                               |
|     PUT       |     /tema                          |     Altera dados na tabela.                                               |
|     DELETE    |     /tema/{id}                     |     Deleta dados pelo ID.                                                 |


Nossa tabela terá todos os __End-Points__ básicos, isto é, **Get**, **Post**, **Put** e **Delete**. Aliado a isto, criamos um método geral, para buscar todos os conteúdos dentro da tabela, bem como outros três métodos de busca específicos: por id, conteúdo e data e hora.  


 <h2> •	Json: </h2>
 
 <h5> - Postando dados (inserindo dados no banco de dados – método get): </h5>

~~~
{
	“conteudo”: “doação”
	//data e hora não será necessário informar. Será inserido automaticamente pelo Java.
}
~~~


<h5> - Recebendo dados:</h5>

~~~
{
	“id”: 1,
	“conteudo”: “doação”,
	“dataehora”: “2020-09-01T13:47:44.663+00:00”,
	“postagem”: null
}
~~~

<h5> - Consultando dados:</h5>

~~~
{
	“id”: 1,
	“conteudo”: ”Doação”,
	“dataehora”: “2020-09-01T13:47:44.663+00:00”,
	“postagem”:
   [
 	{
		“id”: 1,
		“titulo”: “doação-vidro”,
		“descricao”: “2kg em vidro disponível para doação. Retirada na R. dos Javalis, 12.”,
		“regiao”: “Jabaquara-SP”,
		“data”: “2020-12-11”,
		“material”: “vidro”,
		“tipopresenca”: “true”
 	}
   ]
}
~~~
 
 
 <h2> •	Tabela Postagem </h2>
 
|     ATRIBUTO                    |     TIPO                              |
|---------------------------------|---------------------------------------|
|     ID                          |     Long (BigInt - MySql)             |
|     Título                      |     String (Varchar – 50 - MySql)     |
|     Descrição                   |     String (Text - MySql)             |
|     Região                      |     String (Varchar - 50)             |
|     Data                        |     Date (Date - MySql)               |
|     Imagens                     |     String (Varchar-255 - MySql)      |
|     Material                    |     String (Varchar – 100 - MySql)    |
|     Tipo_presenca               |     Boolean                           |
|     Tema_id [Foreign Key]       |     Long (Bigint - MySql)             |
|     Usuário_id [Foreign Key]    |     Long (Bigint - MySql)             |
 
 
A tabela _POSTAGEM_ possuirá o atributo (i) título, com o resumo do objetivo da postagem que o usuário fará; (ii) descrição, com os detalhes da postagem; (iii) região, com o objetivo de informar em qual região da cidade os materiais estarão disponíveis para retirada e/ou a região em que ocorrerá a oficina, p.ex.; (iv) data, com a data da postagem; (v) imagens, para que o usuário detalhe seu post utilizando quaisquer imagens que entender relevantes; (vi) material, na qual o usuário poderá escolher se será sobre oficinas, cursos, doações, qual tipo de material doado etc.<br>

Haverá, ainda, dois atributos que farão o papel de chaves estrangeiras da tabela, ligando-a com a tabela TEMA e a tabela USUÁRIO, quais sejam: tema_id e usuário_id. A conexão será feia por meio da anotação <b>@ManyToOne</b>.<br>

Para evitar o problema da recursividade, usaremos, também, a anotação <b>@JsonIgnoreProperties</b>.<br>

 <h2> •	Crud Postagem</h2>
 
|     MÉTODOS    |     END-POINTS                   |     DESCRIÇÃO                                                   |
|----------------|----------------------------------|-----------------------------------------------------------------|
|     GET        |     /postagem                    |     Lista todas as postagens existentes.                        |
|     GET        |     /postagem/{id}               |     Lista as postagens especificadas pela id.                   |
|     GET        |     /postagem/titulo/{titulo}    |     Lista as postagens de acordo com o título.                  |
|     GET        |     /postagem/regiao/{regiao}    |     Lista as postagens de acordo com a região do   usuário.     |
|     GET        |     /postagem/data/{data}        |     Lista as postagens de acordo com a data de   publicação.    |
|     POST       |     /postagem                    |     Insere dados na tabela.                                     |
|     PUT        |     /postagem                    |     Altera dados na tabela.                                     |
|     DELETE     |     /postagem/{id}               |     Deleta dados pelo ID.                                       | 
 
 
Nossa tabela terá todos os __end-points__ básicos, o que possibilitará as operações básicas, isto é, **Get**, **Post**, **Put** e **Delete**. Ainda, teremos um método geral para buscar todas as postagens, bem como alguns métodos específicos filtrando a pesquisa de acordo com a id, o título, região ou data da postagem.
 
<h2> • Json:  </h2>

<h5> - Postando dados (inserindo dados no banco de dados – método POST): </h5>

~~~
{
	“titulo”: “doação”,
	“descricao”: “Olá pessoal, tenho materiais em vidro para doação. Não é uma quantidade muito grande,mas o suficiente para 
	quem estiver trabalhando sozinho e não precise fazer nada em larga escala.”,
	“regiao”: “Jabaquara”,
	“data”: “2020-09-22”,
	“imagens”: “”,
	“material”: “vidro”,
	“tipo_presenca”: true,
	“tema_id”: {
			“id”: 1,
			“conteudo”: “doação”,
			“dataehora”: “2020-09-01T13:47:44.663+00:00”
		   }
}
~~~

<h5> -	Recebendo/consultando dados (método GET): </h5>
•Método para pesquisa:<b>/postagem</b><br>
•Retorno esperado:

~~~
{
	“titulo”: “doação”,
	“descricao”: “Olá pessoal, tenho materiais em vidro para doação. Não é uma quantidade muito grande,mas o suficiente para 
	quem estiver trabalhando sozinho e não precise fazer nada em larga escala.”,
	“regiao”: “Jabaquara”,
	“data”: “2020-09-22”,
	“imagens”: “”,
	“material”: “vidro”,
	“tipo_presenca”: true,
	“tema_id”: {
			“id”: 1,
			“conteudo”: “doação”,
	}
}
~~~


<h5> -	Deletando dados (método DELETE): </h5>
•Método para pesquisa:<b>/postagem/{id}</b><br>
•Retorno esperado:[]<br>

~~~
//retorna status 200 OK. Isso quer dizer que a requisição foi atendida sem erros.
~~~
 
<h2> • Tabela Usuário </h2>
  
|     ATRIBUTO                  |     TIPO                              |
|-------------------------------|---------------------------------------|
|     ID                        |     Long (bigint - MySql)             |
|     Nome                      |     String (varchar – 100 - MySql)    |
|     E-mail                    |     String (varchar – 30 - MySql)     |
|     Senha                     |     String (varchar – 12 - MySql)     |
|     Telefone                  |     int                               |
|     Postagem [Foreign Key]    |     List<Postagem>                    |
 
 A tabela _USUÁRIO_ terá o atributo ID, referente ao código de cada usuário, além dos atributos **nome**, **e-mail**, **senha** e **telefone**.
 
  <h2> •Crud Usuário </h2>
 
|     MÉTODOS    |     END-POINTS                   |     DESCRIÇÃO                                                     |
|----------------|----------------------------------|-------------------------------------------------------------------|
|     POST       |     /usuario/cadastrar           |     Cadastra o usuário na rede social.                            |
|     POST       |     /usuario/logar               |     Faz o login de um usuário existente.                          |
|     PUT        |     /usuario/atualizarUsuario    |     Faz atualizações em um cadastro de usuário já   existente.    |
 
Nossa tabela __Usuário__ terá os end-points básicos, que possibilitarão as operações **Post** e **Put**, para que o usuário consiga se cadastrar, logar e alterar seu cadastro, se assim desejar.
 
 <h2> • Json:  </h2>
 <h5> - Postando dados (inserindo dados no banco de dados – método POST): </h5>
 
 ~~~
 {
	“nome”: “Lisbeth Salander”,
	“e-mail”: “lisbeth.salander@gmail.com”,
	“senha”: “123deoliveiraquatro”,
	“telefone”: 11999999999
} 
 ~~~
 
 <h2> • Atualizando dados do usuário: </h2
•Método para pesquisa:<b>/usuario/atualizarUsuario</b><br>
•Resultado esperado:

~~~
{
	“id”: 1,
	“nome”: “Lisbeth Salander”,
	“e-mail”: “lisbeth.salander@gmail.com”,
	“senha”: “123deoliveiraquatro”,
	“telefone”: 1199999994444

}
~~~
 



:house_with_garden: [Home](https://github.com/WeslleyRocha/Projeto-Integrador-Generation) :house_with_garden:
