# Pedidos (microservicio demo)

Puerto **8082**. Depende del catálogo en **8081**.

1. Terminal A: en `04-microservicios-catalog` → `mvn spring-boot:run`
2. Terminal B: aquí → `mvn spring-boot:run`

```bash
curl -s http://localhost:8082/api/orders/o-1 | jq
```

Deberías ver `productName` rellenado desde el catálogo. Si apagas el catálogo, el pedido sigue existiendo pero el nombre muestra el mensaje de indisponibilidad.
