# 01 — Fundamentos y configuración

## Ejecutar

```bash
mvn spring-boot:run
```

Con perfil **dev** (activa bean `DevOnlyGreeter`, flag `extra-endpoint` y ruta funcional `/api/extra-feature`):

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Probar

- `GET http://localhost:8080/api/info` — perfiles activos y mensaje según YAML.
- Con `dev`: `GET http://localhost:8080/api/dev-greeting` y `GET http://localhost:8080/api/extra-feature`.
- `GET http://localhost:8080/actuator/health`

## Variables de entorno

Ejemplo: `SERVER_PORT=8081` para cambiar puerto sin tocar archivos.
