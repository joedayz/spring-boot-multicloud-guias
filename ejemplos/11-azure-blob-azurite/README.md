# 11 — Azure Blob con Azurite (local)

## 1. Levanta Azurite

```bash
docker compose up -d
```

Blob API escucha en el puerto **10000** (endpoint en `application.yml`).

## 2. Arranca Spring Boot

```bash
mvn spring-boot:run
```

## 3. Probar

```bash
curl -X PUT http://localhost:8080/api/blobs/hola.txt -H "Content-Type: text/plain" -d "contenido demo"
curl http://localhost:8080/api/blobs/hola.txt
```

## Producción (Azure)

- Crea una **Storage Account** y obtén la cadena de conexión desde el portal.
- No la subas al repo: `export AZURE_STORAGE_CONNECTION_STRING=...`
- **Key Vault** + **managed identity** es el patrón recomendado para secretos.

## CI/CD (GitHub Actions)

Ejemplo de flujo: build con `mvn test`, despliegue a **Azure App Service** o **Container Apps** con secretos en GitHub Actions (`AZURE_CREDENTIALS`, variables de conexión). Plantilla oficial: [https://github.com/Azure/actions](https://github.com/Azure/actions)
