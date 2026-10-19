# Thymeleaf Web
Aplicação web Java 17 + Spring Boot + Thymeleaf + Spring Data JPA + H2.
## Executar
Na pasta `thymeleaf-web`, execute `mvn spring-boot:run`; abra http://localhost:8080.
Console H2: http://localhost:8080/h2-console | JDBC URL `jdbc:h2:mem:thymeleafweb` | usuário `sa` | senha vazia.
## Funcionalidades
Dashboard, navegação lateral, CRUD de funcionários/contas/veículos/serviços, pesquisa textual e layout responsivo.
O banco H2 é em memória. A aplicação web possui banco próprio nesta versão; integração HTTP com a API é uma melhoria futura recomendada.
