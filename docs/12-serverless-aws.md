# 12. Serverless en AWS

## Objetivos

- **AWS SDK v2** para Java: configuración y buenas prácticas.
- **AWS CLI** para pruebas rápidas.
- **Lambda** con Spring (snapstart o enfoque ligero según guía actual).
- **API Gateway** delante de Lambda.
- **Cognito** como autorizador (concepto + demo mínima).
- **SAM** para pruebas locales.

## Paso 1 — SDK y CLI

1. Añade BOM o BOM de AWS SDK v2 al proyecto.
2. Configura región y credenciales (perfil `~/.aws/credentials`, nunca en código).
3. Prueba CLI: `aws sts get-caller-identity`.

**Checklist:** Misma cuenta y región en CLI y app.

## Paso 2 — Lambda con Spring Boot

1. Lee la guía oficial actual (el empaquetado de Spring en Lambda cambia con el tiempo).
2. Handler que delega en el contexto Spring o función pura Java según el tutorial que sigas.
3. Empaqueta sombra/shade correctamente (ojo con tamaño en frío).

**Checklist:** Invocación de prueba en consola Lambda con payload JSON.

## Paso 3 — API Gateway

1. Crea HTTP API o REST API según necesidad.
2. Integra con Lambda; prueba desde la consola y con `curl`.

**Checklist:** URL pública (o protegida) coherente con el handler.

## Paso 4 — Cognito + API Gateway

1. User pool mínimo y cliente de aplicación.
2. Authorizer JWT en API Gateway.
3. Spring/Lambda lee claims del token (sub, grupos).

**Checklist:** Sin token → 401; con token de usuario de prueba → 200.

## Paso 5 — SAM local

1. `template.yaml` mínimo con función y evento de prueba.
2. `sam local invoke` y `sam local start-api`.

**Checklist:** Mismo comportamiento que en la nube para un caso feliz.

## Para YouTube

- Aviso de cold start y tamaño del deployment; comparar con Lambda “thin” sin Spring si el vídeo es largo.
