# 02 — API REST con validación y OpenAPI

## Ejecutar

```bash
mvn spring-boot:run
```

## Probar

- Swagger UI: http://localhost:8080/swagger-ui.html (si no carga, prueba `/swagger-ui/index.html` según tu versión de springdoc)  
- H2 Console: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:dfc`, user `sa`, password vacío)

### curl

```bash
curl -s http://localhost:8080/api/products | jq
curl -s -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Mouse","price":59.90,"sku":"SKU-MOUSE-01"}' | jq
```

SKU inválido (sin prefijo `SKU-`) → **400** con `fieldErrors` en el JSON.
