# Ejemplos ejecutables (Spring Boot)

Cada carpeta es un **proyecto Maven** (salvo indicación). Requisitos: **JDK 17+** y **Maven 3.9+**.

## Tabla rápida

| Carpeta | Guía | Cómo ejecutar |
|---------|------|---------------|
| [01-fundamentos-configuracion](01-fundamentos-configuracion/) | [docs/01](../docs/01-fundamentos-configuracion.md) | `mvn spring-boot:run` |
| [02-rest-api](02-rest-api/) | [docs/02](../docs/02-rest-apis.md) | `mvn spring-boot:run` → Swagger |
| [03-persistencia](03-persistencia/) | [docs/03](../docs/03-persistencia.md) | `mvn spring-boot:run` (Redis opcional) |
| [04-microservicios-catalog](04-microservicios-catalog/) | [docs/04](../docs/04-microservicios.md) | Puerto 8081 |
| [04-microservicios-pedidos](04-microservicios-pedidos/) | [docs/04](../docs/04-microservicios.md) | Puerto 8082 |
| [05-arquitectura-hexagonal](05-arquitectura-hexagonal/) | [docs/05](../docs/05-arquitectura-avanzada.md) | `mvn spring-boot:run` |
| [06-graphql](06-graphql/) | [docs/06](../docs/06-graphql.md) | GraphiQL |
| [07-spring-cloud](07-spring-cloud/) | [docs/07](../docs/07-spring-cloud.md) | Multi-módulo: Eureka → Config → pricing → inventory (ver README) |
| [08-pruebas-sonarqube](08-pruebas-sonarqube/) | [docs/08](../docs/08-pruebas-sonarqube.md) | `mvn test` |
| [09-seguridad-cloud](09-seguridad-cloud/) | [docs/09](../docs/09-seguridad-cloud.md) | JWT + `/api/me` |
| [10-serverless-azure](10-serverless-azure/) | [docs/10](../docs/10-serverless-azure.md) | `mvn package` + `func start` |
| [11-azure-blob-azurite](11-azure-blob-azurite/) | [docs/11](../docs/11-azure-persistencia.md) | `docker compose up` + Spring |
| [12-aws-sam-lambda](12-aws-sam-lambda/) | [docs/12](../docs/12-serverless-aws.md) | `sam build` / `sam local start-api` |
| [13-aws-dynamodb-local](13-aws-dynamodb-local/) | [docs/13](../docs/13-aws-persistencia.md) | DynamoDB local + `mvn spring-boot:run` |

## Licencia del código

Los proyectos de ejemplo se publican bajo [MIT](LICENSE-CODE) salvo que indiques otra licencia en tu fork.

## Notas

- Módulos **7** y **4** (microservicios) requieren **varios procesos** o terminales; el orden está en cada `README.md`.
- **10–13** pueden usar **Docker** (Azurite, DynamoDB local) o **SAM CLI** / **Azure Functions Core Tools**; en la nube real hacen falta cuenta y permisos IAM/RBAC.
