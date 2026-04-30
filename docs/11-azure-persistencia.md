# 11. Persistencia y despliegue en Azure

## Objetivos

- Elegir **NoSQL vs relacional** para un caso de uso.
- **Cosmos DB** con SDK Java.
- **Azure SQL** con JDBC.
- **Blob Storage** para archivos.
- Secretos en **Key Vault** + **Application Insights** para telemetría.
- **GitHub Actions** para un pipeline simple.

## Paso 1 — Decisión NoSQL vs SQL

1. Lista acceso por clave vs joins complejos, consistencia, tamaño de documentos.
2. Elige Cosmos (API Core SQL o Mongo) vs Azure SQL para tu demo.

**Checklist:** Justificas la elección en 3 frases.

## Paso 2 — Cosmos DB

1. Crea cuenta Cosmos (modo serverless o provisioned según presupuesto demo).
2. Usa SDK Java para crear/leer un ítem.
3. Maneja `partition key` correctamente.

**Checklist:** CRUD mínimo funciona desde una app Spring o consola.

## Paso 3 — Azure SQL

1. Crea servidor SQL y firewall (tu IP).
2. Conecta con Spring Data JPA o JDBC clásico.
3. No guardes usuario/contraseña en el repo: Key Vault.

**Checklist:** Migraciones Flyway/Liquibase opcionales pero recomendadas.

## Paso 4 — Blob Storage

1. Sube un archivo desde Java con SDK.
2. Genera SAS o usa identidad con permisos mínimos.

**Checklist:** List/get desde la app sin URL pública ancha innecesaria.

## Paso 5 — Key Vault + aplicación

1. Referencia secretos como propiedades de Spring (`spring.cloud.azure.keyvault.secret`).
2. Comprueba que en local usas perfil distinto al de Azure.

**Checklist:** Cero secretos en Git.

## Paso 6 — Application Insights

1. Añade agente o dependencia según documentación actual.
2. Envía un log y una métrica custom de prueba.
3. Abre el recurso en el portal y verifica trazas.

**Checklist:** Puedes filtrar por `operation_Id` o request.

## Paso 7 — GitHub Actions

1. Workflow: build → test → deploy a App Service o Container con `azure/login`.
2. Secretos `AZURE_CREDENTIALS` en GitHub Secrets.

**Checklist:** Push a `main` despliega (o manual `workflow_dispatch` al principio).

## Para YouTube

- Un vídeo “arquitectura datos Azure”, otro “CI/CD” para no mezclar demasiado.
