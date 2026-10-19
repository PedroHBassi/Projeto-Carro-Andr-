# Thymeleaf API
API REST em Java 17, Spring Boot, Spring Data JPA e H2.
## Executar
Na pasta `thymeleaf-api`: `mvn spring-boot:run`. API em http://localhost:8081.
Console H2: http://localhost:8081/h2-console | JDBC URL `jdbc:h2:mem:thymeleafapi` | usuário `sa` | senha vazia.
## Endpoints CRUD
- Funcionários: `/api/funcionarios` (chave CPF)
- Contas do mês: `/api/contas-do-mes` (chave ID)
- Veículos: `/api/veiculos` (chave placa)
- Serviços: `/api/servicos` (chave ID)
Cada recurso aceita GET (lista e item), POST, PUT e DELETE. Datas devem usar `AAAA-MM-DD`. H2 está configurado em memória; dados são reiniciados ao encerrar.
