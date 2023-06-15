# checkchap-api
Plataforma Intuitiva e Ágil para Criação e Compartilhamento de Listas de Tarefas Online - Projeto final das disciplinas de Engenharia de Software e Projeto de Software 

## Documentação para consumir a API

### URL

* Criar uma URL: 

Url: localhost:8080/ 

Metodo: POST 

Body: “url” => valor

Retorno: a própria URL com id, url e data de criação. 


* Acessar uma URL: 

Url: localhost:8080/

Metodo:GET 

Header: idUrl 

Retorno: o nome da url.



### TAREFA
* Criar uma TAREFA: 

Url: localhost:8080/tarefa

Metodo: POST 

Body: “titulo” => valor, “id_url” => valor

Retorno: a própria tarefa com id, id_url e titulo. 


* Acessar uma TAREFA: 

Url: localhost:8080/ 

Metodo: GET 

header: - tarefa/{idUrl} 

Retorno: o titulo da tarefa e seu id. 


* Editar titulo de uma TAREFA: 

Url: localhost:8080/ 

Metodo: PUT 

header: tarefa/{id_tarefa}/novotitulo 

Retorno: a própria tarefa


* Deletar uma TAREFA: 

Url: localhost:8080/ 

Metodo: DELETE 

header: tarefa/{id_tarefa} 

Retorno: a própria tarefa



### ITEM
* Criar um ITEM: 

Url: localhost:8080/item

Metodo: POST 

Body: “id_tarefa” => valor, “nome” => valor, “situacao” => valor

Retorno: o item com id, nome e situacao. 


* Acessar ITENS: 

Url: localhost:8080/

Metodo: GET

header: item/{idTarefa} 

Retorno: array de item e seus relacionamentos 


* Editar o nome de um ITEM

Url: localhost:8080/item

Metodo: PUT

header: nome/id_item/novonome

Retorno: o 'novo' item


* Editar a situação de um ITEM

Url: localhost:8080/item

Metodo: PUT

header: situacao/id_item/situacao (1 / 0)

Retorno: o 'novo' item


* Deletar um ITEM

Url: localhost:8080/item

Metodo: DELETE

header: id_item

Retorno: o item


