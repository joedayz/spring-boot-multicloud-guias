# 3. Persistencia con base de datos

## Objetivos

- Usar **Spring Data JPA** con buen modelo de dominio.
- Dominar propagación y aislamiento de **transacciones**.
- Integrar **MongoDB** en un API REST.
- Usar **Redis** como caché.

## Paso 1 — Spring Data JPA

1. Añade `spring-boot-starter-data-jpa` y una BD en memoria (H2) o Docker (PostgreSQL).
2. Define entidad, repositorio `JpaRepository`, servicio y capa REST.
3. Prueba consultas derivadas (`findBy...`) y `@Query` JPQL cuando haga falta.

**Checklist:** CRUD persistente end-to-end.

## Paso 2 — Transacciones avanzadas

1. Marca el servicio con `@Transactional` y prueba **rollback** ante excepción.
2. Experimenta `propagation = REQUIRES_NEW` en un método interno (ojo: self-invocation: usa otro bean o `@Async` según el caso).
3. Documenta en comentarios cuándo usar `READ_COMMITTED` vs `SERIALIZABLE` en tu caso de uso.

**Checklist:** Explicas en voz alta por qué elegiste cada propagación en el demo.

## Paso 3 — MongoDB

1. Nuevo perfil o proyecto con **Spring Data MongoDB**.
2. Modela documentos con `@Document`, repositorio `MongoRepository`.
3. Expón los mismos endpoints REST adaptados al modelo documental.

**Checklist:** Datos visibles en Compass o `mongosh`.

## Paso 4 — Redis (caché)

1. Levanta Redis con Docker: `docker run -p 6379:6379 redis:alpine`.
2. Añade `spring-boot-starter-data-redis` y `@EnableCaching`.
3. Anota un método de lectura con `@Cacheable("items")` e invalida con `@CacheEvict` al actualizar.

**Checklist:** Segunda llamada no golpea BD (log o breakpoint).

## Para YouTube

- Bloque corto “JPA vs Mongo cuándo usar” al inicio para retención.
