
# Avaliação técnica
Aplicação com objetivo de realizar cadastro de propostas de crédito para um determinado cliente.

## Tecnologias utilizadas
  - Frontend: [AngularJS], [Html5], [Bootstrap4]
  - Backend: [Java], [Spring-boot], [Spring-data-jpa]
  - Integrações: [Rest], [Restful], [Hateoas]
  - Documentação: [Swagger]

## Arquitetura 
- Foram desenvolvidos dois projetos. Um para o back-end e outro para o front-end.

### Backend
- Solução desenvolvida em Java utilizando Spring-boot, Spring-data-jpa.
 - API Restful disponível na porta 8080 contendo documentação swagger dos endpoints disponível em `http://localhost:8080/swagger-ui.html`.

### Frontend  
- Solução desenvolvida em AngularJS, Gulp, Html5, e CSS3 utilizando Bootstrap4.

### Banco de dados
- Para avaliação foi utilizado o banco de dados em memória, H2, alguns dados iniciais são populados através de um script sql na pasta de resources.

### Build

##### Backend com Maven
- para compilar este projeto basta acessar o diretório raiz do projeto `credit-analysis-api` e executar o comando 
```sh 
$ mvn clean package
``` 
- para executar a aplicação basta acessar o diretório raiz do projeto `credit-analysis-api` e executar o comando 
```sh 
$ mvn spring-boot:run
``` 

##### Frontend
- para executar este projeto basta acessar o diretório raiz do projeto `credit-analysis-ui` e executar o comando abaixo e automaticamente será aberto a aplicação no navegador padrão do sistema.
```sh 
$ npm install && npm run dev
``` 

## Documentação
- esta aplicação possui documentação da API Rest disponível através da ferramenta Swagger em /swagger-ui.html

### Observações 
> Devido ao curto prazo não foi criado um script para inicialização da aplicação utilizando docker.

   [AngularJS]: <http://angularjs.org>	
   [Html5]: <https://www.w3.org/TR/html5/>
   [Bootstrap]: <http://getbootstrap.com/>
   [Java]: <http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html>
   [Spring-boot]: <https://projects.spring.io/spring-boot/>
   [Rest]: <https://www.w3.org/2001/sw/wiki/REST>
   [Swagger]: <https://swagger.io/>  
   [Bootstrap4]: <https://getbootstrap.com/docs/4.0/>
   [Spring-data-jpa]: <https://spring.io/projects/spring-data-jpa>
   [Restful]:<https://www.devmedia.com.br/introducao-a-web-services-restful/37387>
   [Hateoas]: <https://spring.io/understanding/HATEOAS>



# Avaliação Técnica - ORIGINAL

[![drawing](https://sitegabriela.conductor.com.br/App_Themes/8/Images/Logos/BannerSite.png)](http://www.calcard.com.br/)

Desenvolver uma aplicação web que realize o cadastro de proposta de crédito para um determinado cliente, efetue a análise de dados e efetive a aprovação ou negação de um limite de crédito para o mesmo.

A proposta de crédito consiste em um formulário contendo as seguintes informações de cadastro de cliente:
- Nome
- CPF
- idade
- sexo
- estado civil
- estado
- dependentes
- renda

Deve ser criado um algoritmo de análise de crédito, que vai avaliar as informações de entrada e definir se o cliente foi negado ou se foi aprovado. Além disso, o algoritmo deve informar em qual faixa de limite de crédito o cliente se encaixou.

  - O sistema deve realizar a análise do cliente baseado nas informações cadastrais da proposta.
  - O sistema deve gravar o cadastro da proposta no banco de dados.
  - O sistema deve efetuar a tomada de decisão da proposta, aprovando-a ou negando-a.   
  - Após o cadastro da proposta e tomada de decisão, o sistema deve apresentar o resultado da análise. 
  - Aprovação da proposta deve estar composta com valor de limite de crédito sugerido pelo sistema.
  - A Negação deve estar composta pelo motivo da não aprovação.
  - O sistema deve permitir a consulta de aprovação/negação do cliente pelo cpf.
  
### Sugestão de Tecnologias

  - Frontend: [AngularJS], [Html5], [Bootstrap]
  - Backend: [Java], (Recomendamos [Spring-boot])
  - Integrações: [Rest] conceito Restful
  - Documentação: [Swagger]
  

### Resultado da Análise  

- O seu melhor já é o suficiente: Ainda que seu código tenha problemas, consideraremos o esforço e os pontos positivos. :)

- Analisando os seguintes dados de entrada do formulário: Nome, idade, sexo, estado civil, estado, dependentes, renda mensal.
- Espera-se que o algoritmo de análise e tomada de decisão retorne os seguintes resultados:

| NOME   | IDADE  | SEXO   | ESTADO CIVIL | ESTADO | DEPENDENTES| RENDA R$| RESULTADO ANÁLISE | LIMITE | 
| ------ | ------ | ------ | ------       | ------ | ------     | ------  | ------            | ------ |        
| Lucas	 | 28     | M      | solteiro     |	SC     | 0          | 2500    | Aprovado          | entre 500 - 1000  |
| Ana	 | 17     | F	   | solteiro     |	SP     | 0          | 1000    | Aprovado          | entre 100 - 500   |
| Pedro	 | 68     | M      | casado	      | SC	   | 3          | 8000    | Aprovado          | entre 1500 - 2000 |
| Paula	 | 61     | F      | casado	      | RJ	   | 3          | 5000    | Aprovado          | entre 1000 - 1500 |
| João	 | 56     | M      | divorciado   |	RJ	   | 2          | 2000    | Negado            | reprovado pela política de crédito |	
| Maria	 | 45     | F      | divorciado   | SP	   | 1          | 2000    | Negado            | reprovado pela política de crédito |
| José	 | 30     | M      | casado       |	MA	   | 2          | 8000    | Aprovado          | superior 2000     |
| Dinae  | 33     | F      | casado	      | SP	   | 1          | 10000   | Aprovado          | superior 2000     |
| Marcos | 19     | M      | solteiro     |	SC	   | 1          | 400     | Negado            | renda baixa       |	
| Suzan  | 63     | F      | viuva	      | MA	   | 3          | 1500    | Negado            | reprovado pela política de crédito |
| Luci   | 28     | F      | solteiro     | SC     | 2          | 2500    | Aprovado          | entre 100 - 500   |
| Roberto| 16     | M      | solteiro     | SP     | 0          | 500     | Negado            | renda baixa       |
| Bruno  | 30     | M      | casado       | MA     | 5          | 8000    | Aprovado          | entre 1000 - 1500 |
| Ariel  | 33     | F      | viuva        | SP     | 0          | 10000   | Aprovado          | superior 2000     |      

### Sugestão de Arquitetura 

  - Frontend/Backend.
  - Backend com conceito de Api contendo documentação swagger dos endpoints.
  - API para cadastro e consulta das propostas.
  - API motor de crédito que efetuará a análise da proposta e realizará a tomada de decisão do limite de crédito.
  
### Desafios

  - Criar inteligência de decisão do motor de crédito.
  - Disponibilizar o projeto com configurações para execução em docker. 

### Observações 

> A apresentação dos dados no frontend e arquitetura ficam a critério do desenvolvedor.
> Padrões de projeto, código limpo, melhores práticas, testes unitários, padrões Solid, documentação swagger e documentação do código fazem parte do escopo do projeto.
> A criação do algoritmo de análise de crédito e tomada de decisão é responsabilidade do desenvolvedor. A criatividade será avaliada.  
> Disponibilizar documentação para execução do sistema.
> Surpreenda-nos. 
  
### Publicação

O projeto deve estar documentado e publicado no github.
Favor nos enviar o endereço do repositório do projeto para o(s) e-mail(s): ramon.felipe@calcard.com.br; diego.nunes@calcard.com.br;


License
----

Calcard Administradora de Cartões


**Boa sorte!**

   [AngularJS]: <http://angularjs.org>	
   [Html5]: <https://www.w3.org/TR/html5/>
   [Bootstrap]: <http://getbootstrap.com/>
   [Java]: <http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html>
   [Spring-boot]: <https://projects.spring.io/spring-boot/>
   [Rest]: <https://www.w3.org/2001/sw/wiki/REST>
   [Swagger]: <https://swagger.io/>
