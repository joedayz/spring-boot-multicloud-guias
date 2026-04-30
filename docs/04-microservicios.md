# 4. Microservicios

## Objetivos

- Entender límites de servicio y despliegue independiente.
- Estructura típica de un microservicio Spring Boot.
- **Actuator** para salud y métricas.
- **Dockerizar** el servicio.
- Comunicación **síncrona** con `RestTemplate` y **WebClient** (preferido para no bloquear).

## Paso 1 — Fundamentos y estructura

1. Define un dominio acotado (por ejemplo “catálogo de productos”).
2. Paquetes sugeridos: `api` (DTOs), `application` (casos de uso), `domain`, `infrastructure`.
3. Dependencias mínimas: **Spring Web**, **DevTools**, **Actuator**.

**Checklist:** Un microservicio autónomo con su propia BD o esquema.

## Paso 2 — Actuator y configuración

1. Expón `health`, `info`, `metrics` (ajusta `management.endpoints.web.exposure.include`).
2. Perfiles `dev`/`prod` con URLs de BD distintas.

**Checklist:** `/actuator/health` usable para un balanceador o orquestador.

## Paso 3 — Docker

1. Escribe un `Dockerfile` multi-stage: build con Maven/Gradle + imagen JRE ligera.
2. `docker build` y `docker run` mapeando puerto.
3. (Opcional) `docker-compose.yml` con tu BD.

**Checklist:** Mismo comportamiento que en local.

## Paso 4 — Comunicación entre servicios

1. **Servicio B** expone un recurso REST.
2. En **Servicio A**, usa `WebClient` para llamar a B (timeouts y manejo de error).
3. (Legado) Muestra `RestTemplate` con `RestTemplateBuilder` y por qué WebClient es preferible en código nuevo.

**Checklist:** Llamada A→B estable con logs de latencia.

## Para YouTube

- “Un microservicio no es solo un JAR pequeño”: 2 minutos sobre acoplamiento y contratos (OpenAPI compartido).
