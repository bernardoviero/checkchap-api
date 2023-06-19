# chechchap-api

Api para a implementação de uma Plataforma Intuitiva e Ágil para Criação e Compartilhamento de Listas de Tarefas Online - Projeto final das disciplinas de Engenharia de Software e Projeto de Software

## API Reference

* Obs: Os métodos GET/PUT/DELETE passam seus parâmetros por meio do HEADER já o método POST passa parâmetros pelo BODY

#### Criar url

```http
  POST /
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `url` | `string` | O nome da sua rota |

#### Visualizar url

```http
  GET /{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Id da URL |

#### Criar tarefa

```http
  POST /tarefa
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `titulo`      | `string` | Nome de sua tarefa |
| `idUrl`      | `int` | Id da URL relacionada |

#### Visualizar uma tarefa

```http
  GET /tarefa/{idUrl}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idUrl`      | `int` | Id de url a qual sua tarefa está relacionada |

#### Editar uma tarefa

```http
  GET /tarefa/{idTarefa}/{nome}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idTarefa`      | `int` | Id de tarefa |
| `nome`      | `string` | Novo nome da tarefa |

#### Excluir uma tarefa

```http
  DELETE /tarefa/{idTarefa}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idTarefa`      | `int` | Id de tarefa para exclusão |

#### Criar um item

```http
  POST /item
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nome`      | `string` | Nome do item |
| `idTarefa`      | `int` | Id da tarefa relacionada |
| `situacao`      | `bool` | Padrão 0 -> Á fazer |

#### Visualizar um item

```http
  GET /item/{idTarefa}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idTarefa`      | `int` | Id da tarefa a qual os itens estão relacionados

#### Editar a situação de um item

```http
  PUT /item/situacao/{idItem}/{situacao}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idItem`      | `int` | Id do item a ser atualizado|
| `situacao`      | `bool` | Situação do item (1) -> concluído. (0) -> A fazer|

#### Editar o nome de um item

```http
  PUT /item/nome/{idItem}/{nome}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idItem`      | `int` | Id do item |
| `nome`      | `string` | Novo nome do item |

#### Excluir um item

```http
  DELETE /item/{idItem}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idItem`      | `int` | Id do item para exclusão |
