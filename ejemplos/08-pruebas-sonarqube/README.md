# 08 — Pruebas y calidad (JUnit, Mockito, JaCoCo, SonarQube)

## Ejecutar tests y cobertura

```bash
mvn test
```

Informe JaCoCo: `target/site/jacoco/index.html`

## SonarQube / SonarCloud

1. Crea un proyecto en [SonarCloud](https://sonarcloud.io) (gratis para repos OSS) o levanta SonarQube local con Docker.
2. Copia `sonar-project.properties` y reemplaza `sonar.projectKey` y, en SonarCloud, `sonar.organization`.
3. Genera cobertura XML para Sonar (añade al `pom` el goal `jacoco:report` si hace falta tras `test`):

```bash
mvn verify sonar:sonar -Dsonar.login=TU_TOKEN
```

En CI, guarda el token como secreto (`SONAR_TOKEN`).
