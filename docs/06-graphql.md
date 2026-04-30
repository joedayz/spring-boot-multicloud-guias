# 6. Spring for GraphQL

## Objetivos

- Entender cuándo GraphQL aporta frente a REST.
- Implementar **queries** y **mutations** con Spring GraphQL.
- Comparar contratos REST vs esquema GraphQL.

## Paso 1 — Conceptos

1. Lee el esquema: `type Query`, `type Mutation`, tipos escalares y objetos.
2. Compara: REST = muchos endpoints; GraphQL = un endpoint, cliente pide campos.

**Checklist:** Explicas over-fetching y under-fetching en un ejemplo real.

## Paso 2 — Proyecto Spring GraphQL

1. Añade **spring-boot-starter-graphql** (ver compatibilidad con tu versión de Boot).
2. Coloca `schema.graphqls` en `src/main/resources/graphql/`.
3. Implementa `DataFetcher` o controllers con anotaciones según el estilo que uses (Spring GraphQL evoluciona: sigue la guía oficial vigente).

**Checklist:** GraphiQL o IDE plugin ejecuta una query de lectura.

## Paso 3 — CRUD GraphQL

1. Mutations para crear/actualizar/borrar.
2. Validación en la capa de servicio (igual que REST).
3. Manejo de errores: formato GraphQL con `errors` en la respuesta.

**Checklist:** Mismo dominio que tu API REST pero consumido por GraphQL.

## Paso 4 — REST vs GraphQL (vídeo)

1. Tabla: caching HTTP, herramientas, curva de aprendizaje, equipos móviles.
2. Conclusión: GraphQL no sustituye a REST en todos los casos.

## Para YouTube

- Demo lado a lado: mismo recurso con GET REST y query GraphQL con campos parciales.
