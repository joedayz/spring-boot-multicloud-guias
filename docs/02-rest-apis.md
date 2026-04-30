# 2. Aspectos avanzados de RESTful APIs

## Objetivos

- Construir un CRUD REST con buenas prácticas.
- Validar entrada con `@Valid` y validadores personalizados.
- Manejar errores de forma uniforme (`@ControllerAdvice` / `@ExceptionHandler`).
- Documentar con **OpenAPI 3** (Swagger UI).

## Nota sobre async en Java

En el ecosistema Spring, la asincronía se hace con `@Async`, `CompletableFuture` o **WebFlux** (reactivo). “Promesas/async-await” son conceptos de JavaScript; aquí el paralelo es programación reactiva o async en el servidor.

## Paso 1 — CRUD base

1. Define una entidad DTO de entrada/salida (no expongas la entidad JPA directamente si persistes).
2. Implementa `GET` (lista + por id), `POST`, `PUT`, `DELETE` en un `@RestController`.
3. Usa `@RequestMapping` a nivel clase y métodos HTTP explícitos (`@GetMapping`, etc.).

**Checklist:** Postman o `curl` validan los cuatro verbos.

## Paso 2 — Validación

1. Añade Bean Validation (`jakarta.validation`) a los DTO: `@NotNull`, `@Size`, `@Email`.
2. Anota el parámetro del body con `@Valid`.
3. Crea un validador personalizado (`@Constraint` + `ConstraintValidator`) para una regla de negocio simple.

**Checklist:** Peticiones inválidas devuelven 400 con mensajes claros.

## Paso 3 — Errores centralizados

1. Crea `@RestControllerAdvice` con `@ExceptionHandler` para `MethodArgumentNotValidException` y excepciones de dominio.
2. Devuelve un JSON estable: `timestamp`, `status`, `message`, `path` (o tu estándar).
3. Mapea excepciones de “recurso no encontrado” a **404**.

**Checklist:** Todos los errores siguen el mismo formato.

## Paso 4 — OpenAPI / Swagger

1. Añade **springdoc-openapi** (compatible con tu versión de Spring Boot).
2. Anota controladores con `@Operation`, `@ApiResponse` donde aporte valor.
3. Abre `/swagger-ui.html` (o la ruta que indique la doc) y prueba desde el navegador.

**Checklist:** La API es explorable sin Postman obligatorio.

## Para YouTube

- Un vídeo “solo CRUD”, otro “validación + errores + Swagger” para no saturar.
