# 5. Arquitectura hexagonal, limpia, DDD y CQRS

## Objetivos

- Separar **dominio** de infraestructura (hexagonal / puertos y adaptadores).
- Aplicar capas de **Clean Architecture** sin sobre-ingeniería.
- Introducir **DDD** (lenguaje ubicuo, agregados, repositorios de dominio).
- Patrón **CQRS** ligero en Spring (comandos vs consultas).

## Paso 1 — Hexagonal (puertos y adaptadores)

1. Define un **puerto** de entrada (interfaz del caso de uso) y uno de salida (repositorio abstracto).
2. Implementa adaptadores: REST → caso de uso → repositorio JPA/Mongo.
3. El dominio no importa Spring ni anotaciones de framework en entidades puras (opcional pero ideal).

**Checklist:** Podrías cambiar la BD sustituyendo solo el adaptador de persistencia.

## Paso 2 — Clean Architecture (visión práctica)

1. Capas: **Entities** → **Use Cases** → **Interface Adapters** → **Frameworks**.
2. Las dependencias apuntan **hacia dentro** (regla de dependencia).
3. DTOs en el borde; mapeo en adaptadores.

**Checklist:** Diagrama simple en Excalidraw en el vídeo.

## Paso 3 — DDD (mínimo viable)

1. Elige un **agregado** con raíz clara e invariantes (validaciones en el dominio).
2. Repositorio del dominio: interfaz en dominio, implementación en infraestructura.
3. Servicios de dominio solo si la lógica no cabe en la entidad.

**Checklist:** Una regla de negocio está en el dominio, no en el controller.

## Paso 4 — CQRS en Spring

1. Separa **Command** (escritura) y **Query** (lectura) en clases/handlers distintos.
2. Opcional: modelos de lectura optimizados (proyecciones) distintos del modelo de escritura.
3. No hace falta Event Sourcing para enseñar CQRS: basta separación clara y quizá dos controladores o servicios.

**Checklist:** Flujo de “crear” vs “listar/detalle” claramente separado en código.

## Para YouTube

- Advertencia honesta: no conviertas un CRUD en hexagonal de 40 carpetas; escala según complejidad.
