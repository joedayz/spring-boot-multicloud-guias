# 9. Seguridad en la nube (JWT y secretos)

## Objetivos

- Autenticación/autorización con **JWT** en Spring Security.
- Leer secretos desde **AWS Secrets Manager**.
- Leer secretos desde **Azure Key Vault** con **Azure Identity**.

## Paso 1 — JWT con Spring Security

1. Añade **Spring Security** y flujo OAuth2 Resource Server con JWT (según tu stack).
2. Emite tokens en un endpoint de login (demo) o usa un IdP de prueba.
3. Protege rutas con `authorizeHttpRequests` y roles/scopes.

**Checklist:** Request sin token → 401; con token válido → 200.

## Paso 2 — AWS Secrets Manager

1. Crea un secreto en la consola AWS o con CLI.
2. En Spring, usa **AWS SDK v2** (`SecretsManagerClient`) o integración con Spring Cloud AWS si aplica.
3. Inyecta credenciales de BD leídas del secreto (no en `application.yml`).

**Checklist:** Rotación manual del secreto y reinicio/config refresh documentados.

## Paso 3 — Azure Key Vault

1. Crea un Key Vault y un secreto.
2. Configura **DefaultAzureCredential** (IDE, service principal en CI, managed identity en Azure).
3. Usa **spring-cloud-azure-starter-keyvault-secrets** o SDK para leer propiedades.

**Checklist:** La app arranca en local con `az login` o variables y en Azure con managed identity.

## Para YouTube

- Comparativa en pantalla: “secretos en repo” tachado en rojo vs Key Vault/Secrets Manager en verde.
