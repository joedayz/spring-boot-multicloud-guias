# 7. Spring Cloud

## Objetivos

- **Service discovery** con Eureka (o alternativa moderna: entender el rol).
- **Config centralizada** con Spring Cloud Config (repaso profundo).
- **Resiliencia** con Circuit Breaker (Resilience4j).

## Paso 1 — Eureka Server

1. Crea un proyecto `discovery-server` con **Spring Cloud Netflix Eureka Server** (ver BOM compatible con tu Boot).
2. Anota la app con `@EnableEurekaServer`.
3. Registra un microservicio cliente con `spring-cloud-starter-netflix-eureka-client`.

**Checklist:** Instancias visibles en el dashboard Eureka.

## Paso 2 — Spring Cloud Config (servidor + clientes)

1. Config Server apuntando a un repo Git o filesystem.
2. Clientes con `spring.config.import` y nombre `spring.application.name`.
3. Refresco: `spring.cloud.refresh` / Actuator `refresh` si usas `@RefreshScope` donde aplique.

**Checklist:** Cambias una propiedad en el repo y el cliente la recibe tras refresh o reinicio.

## Paso 3 — Circuit Breaker (Resilience4j)

1. Añade dependencia **Resilience4j** con Spring Cloud Circuit Breaker.
2. Protege la llamada WebClient/RestTemplate con `@CircuitBreaker` y **fallback**.
3. Simula fallos del servicio B y muestra apertura del circuito en logs/métricas.

**Checklist:** Sin cascada de fallos: el usuario recibe degradación controlada.

## Nota 2025–2026

Netflix Eureka está en modo mantenimiento; para producción muchos equipos usan Kubernetes DNS, Consul, o descubrimiento nativo del proveedor cloud. Sigue siendo útil **pedagógicamente** para enseñar discovery y registro.

## Para YouTube

- Epílogo: “En Kubernetes esto cambia a Services y health checks”.
