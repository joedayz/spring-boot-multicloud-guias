# 03 — Persistencia, transacciones y caché

## Por defecto (Caffeine, sin Docker)

```bash
mvn spring-boot:run
```

- `GET http://localhost:8080/api/items/SKU-DEMO-1` dos veces: el **segundo** request no debería repetir el log “Cargando item desde BD…”.

## Ajuste de stock (transacción)

```bash
curl -s -X POST "http://localhost:8080/api/items/SKU-DEMO-1/stock?delta=-3"
```

Si `delta` deja stock &lt; 0 → **400** y la transacción no aplica el cambio.

## Redis (opcional)

```bash
docker compose up -d
mvn spring-boot:run -Dspring-boot.run.profiles=redis
```

Requiere Redis en `localhost:6379`. La caché usa serialización JSON para `ItemView`.
