# 05 — Hexagonal (mínimo viable)

El **dominio** (`domain.model`, `domain.port`) no importa Spring Data. El adaptador `adapter.out.persistence` traduce entre `Product` y `ProductJpaEntity`.

```bash
mvn spring-boot:run
```

```bash
curl -s -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name":"Taller DFC"}'
```
