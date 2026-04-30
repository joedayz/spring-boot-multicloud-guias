# 12 — AWS Lambda + SAM

Requisitos: **JDK 17**, **Maven**, [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html), Docker (para `sam local`).

## Build e invocación local

```bash
sam build
sam local start-api
```

Prueba `GET http://127.0.0.1:3000/hello` (el puerto lo muestra SAM).

## Desplegar en AWS

```bash
sam deploy --guided
```

## Cognito + API Gateway

Para autorizadores JWT con Cognito, configura el authorizer en `template.yaml` y el User Pool en la consola AWS. Guía: [docs/12-serverless-aws.md](../../docs/12-serverless-aws.md) en este repo.
