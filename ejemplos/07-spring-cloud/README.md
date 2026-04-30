# 07 — Spring Cloud (Eureka, Config Server, Circuit Breaker)

Proyecto **multi-módulo Maven**. Orden de arranque:

1. **Eureka** (puerto 8761)  
2. **Config Server** (8888)  
3. **pricing-service** (8083)  
4. **inventory-service** (8084)

Desde la raíz `07-spring-cloud`:

```bash
cd eureka-server && mvn spring-boot:run
# otra terminal
cd config-server && mvn spring-boot:run
cd pricing-service && mvn spring-boot:run
cd inventory-service && mvn spring-boot:run
```

## Probar

- Eureka UI: http://localhost:8761  
- Precio directo: http://localhost:8083/prices/SKU-1  
- Inventario agrega precio vía cliente: http://localhost:8084/inventory/SKU-1  
- `dfc.demo.label` en la respuesta de pricing debe ser `desde-config-server` si Config Server está activo.

### Circuit breaker

Repite varias veces (o usa un script) con fallos forzados:

```text
http://localhost:8084/inventory/SKU-1?failForward=true
```

Tras varios fallos, el precio pasa a **-1** (`degradedPricing: true`) mientras el breaker está abierto.

Compilar todo:

```bash
mvn -q compile
```
