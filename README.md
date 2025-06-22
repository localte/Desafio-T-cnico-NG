Desafio técnico, consiste em implementar uma API que recebe chamadas HTTP, podendo criar contas com saldo e debitar os valores das contas com uma taxa de acordo com o método de pagamento escolhido. O projeto utiliza Java e Spring Framework.

Há um diagrama sobre o overview do projeto na pasta "desafioPdf".

-É necessário utilizar a versão JAVA 21 ou superior!
-Para executar a aplicação baixe o executavel "desafioNgBiling-0.0.1-SNAPSHOT.jar" que está no projeto. Apóis baixa-lo clique duas vezes nele para executa-lo. 

Possivelmente não irá aparecer nenhuma mensagem de que o projeto foi iniciado, acesse localhost:8080/ para vericar, caso apareceça 
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun Jun 22 12:48:03 BRT 2025
There was an unexpected error (type=Not Found, status=404).

o projeto está sendo executado e agora você pode acessar o banco de dados e fazer requisições API.

Exemplo de requisições:
-Criar CONTA-
POST /conta
json: {
    "numero_conta": 234,
    "saldo":180.37
}

-Verificar se CONTA existe-
GET /conta?numero_conta=234

-Transacao em CONTA-
POST /transacao
{
    "numero_conta": 1,
    "tipo_de_pagamento": "C",
    "valor": 1
}

-Para acessar o banco de dados use localhost:8080/h2-console (username: sa) não há senha. 
