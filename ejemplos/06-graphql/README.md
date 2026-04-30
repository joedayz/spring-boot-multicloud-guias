# 06 — GraphQL (Spring for GraphQL)

```bash
mvn spring-boot:run
```

- **GraphiQL**: http://localhost:8080/graphiql  

Consulta de ejemplo:

```graphql
query {
  books {
    id
    title
  }
  book(id: "1") {
    author
  }
}
```
