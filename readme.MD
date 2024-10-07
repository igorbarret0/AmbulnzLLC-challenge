Solução do desafio backend da [AmbulnzLLC](https://github.com/AmbulnzLLC/fullstack-challenge/tree/master/backend)

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [JUnit5](https://junit.org/junit5/)
- [Mockito](https://site.mockito.org/)



## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/AmbulnzLLC-challenge.git
```

- Construir o projeto:
```
./mvnw clean package
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  PIZZA
```
GET /api/pizzas - Obter a lista das pizzas disponíveis 
```

-  PEDIDOS

POST /api/orders - Fazer um pedido
```
{
    "pizzaName": "Frango",
    "quantity": 2
}
```

```
GET /api/orders - Obter uma lista com todos os pedidos
```

```
GET /api/orders/{orderId} - Obter um pedido a partir do ID
```