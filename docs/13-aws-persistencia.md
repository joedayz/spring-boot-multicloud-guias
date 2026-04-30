# 13. Persistencia y despliegue en AWS

## Objetivos

- **DynamoDB**: PutItem, GetItem, Query con SDK v2.
- **S3**: subir/bajar objetos.
- **RDS PostgreSQL**: conexión desde Lambda o EC2/ECS (según tu demo).
- **CloudWatch** logs y métricas desde Lambda.
- Pipeline **GitHub Actions** hacia AWS.

## Paso 1 — DynamoDB

1. Crea tabla con clave de partición (y orden si aplica) en la consola o CDK/CLI.
2. Desde Java: `DynamoDbClient` put/get; maneja `ConditionalCheckFailedException`.
3. Opcional: **Spring Data DynamoDB** o repositorio manual.

**Checklist:** Idempotencia o manejo de conflictos explicado en el vídeo.

## Paso 2 — S3

1. Crea bucket; revisa bloqueo de acceso público.
2. PutObject/GetObject con SDK; para URLs temporales usa **presigned URLs**.

**Checklist:** No exponer credenciales en el cliente móvil; usar presign en backend.

## Paso 3 — RDS PostgreSQL

1. Crea instancia pequeña para laboratorio; security group solo desde tu IP o VPC.
2. Conecta con Spring + JDBC URL en variable de entorno o Secrets Manager.
3. Opcional: **RDS Proxy** mencionado como siguiente paso para muchas Lambdas.

**Checklist:** Pool de conexiones acorde al runtime (Lambda limita concurrencia).

## Paso 4 — CloudWatch

1. Logs automáticos de Lambda; filtra por `requestId`.
2. Métrica custom con EMF o SDK (según enfoque).
3. Alarma simple (opcional) en SNS/email de prueba.

**Checklist:** Encuentras un error simulado en Logs Insights.

## Paso 5 — GitHub Actions → AWS

1. OIDC a AWS (recomendado) o usuario IAM con claves rotadas (menos ideal).
2. Workflow: build → test → deploy Lambda/API con SAM o CDK.

**Checklist:** Artefacto versionado; despliegue repetible.

## Para YouTube

- Cierra la serie con un diagrama: cliente → API GW → Lambda → DynamoDB/S3 + observabilidad.
