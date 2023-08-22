# Eletro-moderna-Back-and
Projeto em Spring boot, para plataforma de vendas de produtos eletrônicos

Projeto realizado no formado de 3 camadas

Os teste na API deve serguir o seguinte parâmetros em Json

### Adição de cliente
``
{
  "nome": "",
  "documento": "",
  "dataNascimento": "",
  "contatos": [],
  "enderecos": []
}
``
### É necessário adicionar uma categoria, antes de incluir o produto 

``
{"nome":"nome da categoria"}
``

### Produto
{
   "nome":"",
   "preco":,
   "descricao":"",
   "cor":"",
   "categoria":""
}

# Este projeto é integrado com uma API externa via CEP.

APi utilizada para retornar os endereços via CEP


``
localhost:8080/endereco/buscar-cep
``
## O end-point retorna o Json Via CEP  para o front

{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
