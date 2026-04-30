# 09 — Seguridad (JWT) y secretos en la nube

## JWT (local)

```bash
mvn spring-boot:run
```

1. Obtén token: `POST /auth/login` con `{"user":"demo","password":"demo"}`  
2. Llama `GET /api/me` con header `Authorization: Bearer <token>`

```bash
TOKEN=$(curl -s -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" \
  -d '{"user":"demo","password":"demo"}' | jq -r .accessToken)
curl -s http://localhost:8080/api/me -H "Authorization: Bearer $TOKEN"
```

El secreto HS256 se lee de `JWT_SECRET` o del valor por defecto en `application.yml` (solo demos).

## AWS Secrets Manager

En producción, **no** guardes `JWT_SECRET` en el repo. Patrón habitual:

1. Crea el secreto en AWS Secrets Manager (JSON con claves rotadas).
2. En ECS/Lambda, otorga IAM `secretsmanager:GetSecretValue`.
3. En arranque, usa **AWS SDK v2** `SecretsManagerClient` o variables inyectadas por la plataforma.

Documentación: [https://docs.aws.amazon.com/secretsmanager/](https://docs.aws.amazon.com/secretsmanager/)

## Azure Key Vault

1. Crea un secreto en Key Vault.
2. Usa **DefaultAzureCredential** (IDE, service principal en CI, managed identity en Azure).
3. Con Spring: `spring-cloud-azure-starter-keyvault-secrets` o lectura explícita con `SecretClient`.

Documentación: [https://learn.microsoft.com/azure/key-vault/](https://learn.microsoft.com/azure/key-vault/)
