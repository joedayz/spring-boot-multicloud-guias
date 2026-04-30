# 13 — DynamoDB local + AWS SDK v2

## 1. DynamoDB Local

```bash
docker compose up -d
```

## 2. Aplicación

```bash
mvn spring-boot:run
```

En el arranque se crea la tabla `dfc_items` si no existe (solo válido en local / permisos amplios en cuenta real).

## 3. Probar PutItem / GetItem

```bash
curl -X PUT http://localhost:8080/api/items/user-1 -H "Content-Type: text/plain" -d "hola-dynamo"
curl http://localhost:8080/api/items/user-1
```

## AWS real

- Elimina `aws.dynamodb.endpoint` y configura **IAM** (rol en ECS/Lambda, `~/.aws/credentials` en local).
- **CloudWatch**: métricas y logs de Lambda/ECS aparecen en la consola; desde código usa SLF4J y el runtime envía a CloudWatch Logs.

## CI/CD

Ejemplo GitHub Actions: `mvn test`, empaquetado JAR, despliegue con **SAM**, **CodePipeline** o ECS. Plantilla orientativa:

```yaml
# .github/workflows/deploy-aws.yml (añádelo en tu repo si lo necesitas)
on:
  push:
    branches: [main]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: "17"
      - run: mvn -B verify
```

Ajusta credenciales OIDC o `AWS_ACCESS_KEY_ID` con secretos del repositorio.
