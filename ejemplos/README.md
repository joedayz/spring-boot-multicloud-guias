# Ejemplos ejecutables (Spring Boot)

Cada carpeta es un **proyecto Maven independiente**. Requisitos: **JDK 17+** y **Maven 3.9+**.

## Tabla rápida

| Carpeta | Guía relacionada | Cómo ejecutar |
|---------|------------------|---------------|
| [01-fundamentos-configuracion](01-fundamentos-configuracion/) | [docs/01](../docs/01-fundamentos-configuracion.md) | `mvn spring-boot:run` |
| [02-rest-api](02-rest-api/) | [docs/02](../docs/02-rest-apis.md) | `mvn spring-boot:run` → Swagger: `/swagger-ui.html` |
| [03-persistencia](03-persistencia/) | [docs/03](../docs/03-persistencia.md) | Perfil por defecto: `mvn spring-boot:run`. Con Redis: ver README del módulo |
| [04-microservicios-catalog](04-microservicios-catalog/) | [docs/04](../docs/04-microservicios.md) | Terminal 1: `mvn spring-boot:run` (puerto 8081) |
| [04-microservicios-pedidos](04-microservicios-pedidos/) | [docs/04](../docs/04-microservicios.md) | Terminal 2: `mvn spring-boot:run` (puerto 8082) |
| [05-arquitectura-hexagonal](05-arquitectura-hexagonal/) | [docs/05](../docs/05-arquitectura-avanzada.md) | `mvn spring-boot:run` |
| [06-graphql](06-graphql/) | [docs/06](../docs/06-graphql.md) | `mvn spring-boot:run` → GraphiQL: `/graphiql` |

## Licencia del código

Los proyectos de ejemplo se publican bajo [MIT](LICENSE-CODE) salvo que indiques otra licencia en tu fork.

## Notas

- Los puertos y perfiles están documentados en el `README.md` de cada ejemplo.
- Para módulos de nube (AWS/Azure), los ejemplos se irán añadiendo en futuras iteraciones; las guías en `docs/` ya describen los pasos.
