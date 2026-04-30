# 10. Serverless en Azure

## Objetivos

- Configurar SDK y build (Maven/Gradle) para Azure Functions.
- Usar **Azure Portal** y **Azure CLI** para crear recursos.
- Desplegar una función desde **VS Code** o CLI.
- Opcional: empaquetar **JAR/WAR** en **Azure App Service**.

## Paso 1 — Entorno

1. Instala [Azure CLI](https://learn.microsoft.com/cli/azure/install-azure-cli) y ejecuta `az login`.
2. Crea un grupo de recursos de prueba: `az group create`.
3. Instala la extensión **Azure Functions** en VS Code si la usarás.

**Checklist:** `az account show` devuelve la suscripción correcta.

## Paso 2 — Azure Functions (Java)

1. Sigue la guía oficial “Create your first function” para Java.
2. Trigger HTTP mínimo que devuelve JSON.
3. `func start` localmente (Core Tools) y prueba con `curl`.

**Checklist:** Función local OK antes de subir a la nube.

## Paso 3 — Despliegue

1. Publica con VS Code o `func azure functionapp publish`.
2. Verifica URL en el portal y monitoreo básico.

**Checklist:** Misma respuesta local y en la nube.

## Paso 4 — Azure Identity

1. Usa `DefaultAzureCredential` para acceder a un servicio (por ejemplo Storage) desde la función con permisos RBAC mínimos.

**Checklist:** Sin claves en código; identidad gestionada o credenciales locales seguras.

## Paso 5 — App Service (JAR/WAR)

1. Crea App Service para Java y sube el artefacto (ZIP deploy o pipeline).
2. Configura variables de entorno y puerto.

**Checklist:** Actuator/health responde en la URL pública.

## Para YouTube

- Sección “costos”: free tier y apagar recursos al terminar la demo.
