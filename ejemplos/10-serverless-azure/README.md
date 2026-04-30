# 10 — Azure Functions (Java)

Requisitos: **JDK 17**, **Maven**, [Azure Functions Core Tools](https://learn.microsoft.com/azure/azure-functions/functions-run-local) (`func`), cuenta Azure (para desplegar).

## Empaquetar

```bash
mvn clean package
```

## Ejecutar en local

```bash
func start
```

Abre la URL que muestra la consola (GET) para la función `hello`.

## Desplegar

Configura en `pom.xml` del plugin `resourceGroup`, `appName` y región; luego:

```bash
mvn azure-functions:deploy
```

(Necesitas `az login` y suscripción válida.)

## CLI Azure (resumen)

```bash
az group create --name java-functions-group --location eastus
# Crear Function App desde portal o CLI siguiendo la guía oficial y luego deploy con Maven.
```

Documentación actualizada: [https://learn.microsoft.com/azure/azure-functions/functions-create-first-java](https://learn.microsoft.com/azure/azure-functions/functions-create-first-java)
