<h1><b> :memo: Documentação Back-End :bookmark_tabs: </b></h1> 

 
 <h2> •	Crud </h2>

| Métodos       | End-Points                         | Descrição                                                                 |
|---------------|------------------------------------|---------------------------------------------------------------------------|
|     GET       |     /tema                          |     Lista todos os temas existentes.                                      |
|     GET       |     /tema/ {id}                    |     Lista temas específicos por ID.                                       |
|     GET       |     /tema/conteudo/{conteudo}      |     Lista temas específicos de acordo com o   conteúdo.                   |
|     GET       |     /tema/dataehora/{dataehora}    |     Lista temas específicos de acordo com a data   e hora da postagem.    |
|     POST      |     /tema                          |     Insere dados na tabela.                                               |
|     PUT       |     /tema                          |     Altera dados na tabela.                                               |
|     DELETE    |     /tema/{id}                     |     Deleta dados pelo ID.                                                 |


Nossa tabela terá todos os __End-Points__ básicos, isto é, **Get**, **Post**, **Put** e **Delete**. Aliado a isto, criamos um método geral, para buscar todos os conteúdos dentro da tabela, bem como outros três métodos de busca específicos: por id, conteúdo e data e hora.  


 <h2> •	Jaso </h2>
 
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
