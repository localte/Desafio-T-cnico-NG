<br>Desafio técnico, consiste em implementar uma API que recebe chamadas HTTP, podendo criar contas com saldo e debitar os valores das contas com uma taxa de acordo com o método de pagamento escolhido. O projeto utiliza Java e Spring Framework.

<br>Há um diagrama sobre o overview do projeto na pasta "desafioPdf".

<br>-É necessário utilizar a versão JAVA 21 ou superior!
<br>-Para executar a aplicação baixe o executavel "desafioNgBiling-0.0.1-SNAPSHOT.jar" que está no projeto. Apóis baixa-lo clique duas vezes nele para executa-lo. 

<br>Possivelmente não irá aparecer nenhuma mensagem de que o projeto foi iniciado, acesse localhost:8080/ para vericar, caso apareceça 
<br>Whitelabel Error Page
<br>This application has no explicit mapping for /error, so you are seeing this as a fallback.

<br>Sun Jun 22 12:48:03 BRT 2025
<br>There was an unexpected error (type=Not Found, status=404).

<br>o projeto está sendo executado e agora você pode acessar o banco de dados e fazer requisições API.

<br>Exemplo de requisições:
<br>-Criar CONTA-
<br>POST /conta
<br>json: {
<br>    "numero_conta": 234,
<br>    "saldo":180.37
<br>}

<br>-Verificar se CONTA existe-
<br>GET /conta?numero_conta=234
<br>
<br>-Transacao em CONTA-
<br>POST /transacao
<br>{
<br>    "numero_conta": 1,
<br>    "tipo_de_pagamento": "C",
<br>    "valor": 1
<br>}

<br>-Para acessar o banco de dados use localhost:8080/h2-console (username: sa) não há senha. 
