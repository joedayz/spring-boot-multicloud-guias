# Índice de guías paso a paso

Sigue el orden para una progresión lógica, o elige un módulo según tu objetivo.

| # | Guía | Ejemplo (código) | Tema |
|---|------|------------------|------|
| 1 | [Fundamentos…](01-fundamentos-configuracion.md) | [`01-fundamentos-configuracion`](../ejemplos/01-fundamentos-configuracion/) | Spring Boot, YAML, perfiles, beans condicionales, Spring Cloud Config |
| 2 | [APIs REST…](02-rest-apis.md) | [`02-rest-api`](../ejemplos/02-rest-api/) | REST, validación, errores, Swagger/OpenAPI |
| 3 | [Persistencia](03-persistencia.md) | [`03-persistencia`](../ejemplos/03-persistencia/) | JPA, transacciones, MongoDB, Redis |
| 4 | [Microservicios](04-microservicios.md) | [`catalog`](../ejemplos/04-microservicios-catalog/) + [`pedidos`](../ejemplos/04-microservicios-pedidos/) | Estructura, Actuator, Docker, RestTemplate/WebClient |
| 5 | [Arquitectura…](05-arquitectura-avanzada.md) | [`05-arquitectura-hexagonal`](../ejemplos/05-arquitectura-hexagonal/) | Puertos/adaptadores, capas, comandos y consultas |
| 6 | [GraphQL…](06-graphql.md) | [`06-graphql`](../ejemplos/06-graphql/) | Queries, mutations, comparación con REST |
| 7 | [Spring Cloud](07-spring-cloud.md) | [`07-spring-cloud`](../ejemplos/07-spring-cloud/) | Eureka, Config Server, Circuit Breaker |
| 8 | [Pruebas y calidad](08-pruebas-sonarqube.md) | [`08-pruebas-sonarqube`](../ejemplos/08-pruebas-sonarqube/) | JUnit, Mockito, integración, SonarQube |
| 9 | [Seguridad en la nube](09-seguridad-cloud.md) | [`09-seguridad-cloud`](../ejemplos/09-seguridad-cloud/) | JWT, AWS Secrets Manager, Azure Key Vault |
| 10 | [Serverless en Azure](10-serverless-azure.md) | [`10-serverless-azure`](../ejemplos/10-serverless-azure/) | Functions, CLI, despliegue |
| 11 | [Persistencia Azure](11-azure-persistencia.md) | [`11-azure-blob-azurite`](../ejemplos/11-azure-blob-azurite/) | Cosmos DB, SQL, Blob, Key Vault, GitHub Actions |
| 12 | [Serverless en AWS](12-serverless-aws.md) | [`12-aws-sam-lambda`](../ejemplos/12-aws-sam-lambda/) | Lambda, API Gateway, SAM, Cognito |
| 13 | [Persistencia AWS](13-aws-persistencia.md) | [`13-aws-dynamodb-local`](../ejemplos/13-aws-dynamodb-local/) | DynamoDB, S3, RDS, CloudWatch, CI/CD |

## Puntos clave de aprendizaje (mapa mental)

- Iniciativas de solución con **Java Spring Boot**
- **Microservicios** y comunicación entre servicios
- **Hexagonal** y **Clean Architecture** + **DDD** y **CQRS** donde aplique
- **AWS**: Lambda, S3, DynamoDB, API Gateway, Cognito, SAM
- **Azure**: Functions, Blob Storage, Key Vault, Cosmos DB, App Service
- **Pruebas** unitarias/integración y **análisis estático** con SonarQube

## Sugerencia para YouTube

- **Una lista de reproducción** por bloque (por ejemplo: “Spring Boot — Fundamentos”, “Spring Boot — AWS”).
- En cada vídeo: objetivos en los primeros 30 s, demo en el medio, checklist al cierre.
- En la descripción: enlace a la guía `.md` y a la carpeta del **ejemplo** en GitHub cuando exista.
