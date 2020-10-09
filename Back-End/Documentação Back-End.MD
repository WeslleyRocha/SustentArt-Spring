






<h1> Json: </h1>

(a)	Postando dados (inserindo dados no banco de dados – método get):
{
	“conteudo”: “doação”
	//data e hora não será necessário informar. Será inserido automaticamente pelo Java.
}
(b)	Recebendo dados:
{
	“id”: 1,
	“conteudo”: “doação”,
	“dataehora”: “2020-09-01T13:47:44.663+00:00”,
	“postagem”: null
}
(c)	Consultando dados:

{
“id”: 1,
“conteudo”: ”Doação”,
“dataehora”: “2020-09-01T13:47:44.663+00:00”,
“postagem”: [ {
“id”: 1,
“titulo”: “doação-vidro”,
“descricao”: “2kg em vidro disponível para doação. Retirada na R. dos Javalis, 12.”,
“regiao”: “Jabaquara-SP”,
“data”: “2020-12-11”,
“material”: “vidro”,
“tipopresenca”: “true”
}]
}
