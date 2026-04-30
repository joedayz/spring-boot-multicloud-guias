# 8. Pruebas unitarias, integración y SonarQube

## Objetivos

- **JUnit 5** para tests unitarios.
- **Mockito** para aislar dependencias.
- Tests de **integración** con `@SpringBootTest` y Testcontainers opcional.
- **SonarQube** (o SonarCloud) para calidad estática.

## Paso 1 — JUnit 5

1. Escribe tests para una clase pura de dominio (sin Spring).
2. Usa `@ParameterizedTest` para tablas de casos.
3. Ejecuta con Maven/Gradle y mira reportes en `build/reports`.

**Checklist:** Cobertura razonable en lógica crítica (no obsesión con el 100 % sin sentido).

## Paso 2 — Mockito

1. `@ExtendWith(MockitoExtension.class)` y `@Mock` para repositorios.
2. Verifica interacciones con `verify` cuando importe el efecto colateral.
3. Evita mockar lo que no controlas sin necesidad.

**Checklist:** Servicio de aplicación testeado sin levantar BD.

## Paso 3 — Integración / slice tests

1. `@WebMvcTest` para capa web con MockMvc.
2. `@DataJpaTest` para repositorios con H2 o Testcontainers.
3. `@SpringBootTest` + `@Testcontainers` para flujo completo (más lento, menos tests).

**Checklist:** Pirámide de tests: muchos unitarios, pocos integración, muy pocos E2E.

## Paso 4 — SonarQube

1. Levanta SonarQube con Docker (documentación oficial) o usa **SonarCloud** gratis para OSS.
2. Configura `sonar.projectKey` y token en CI o local.
3. Ejecuta análisis con Maven (`sonar-maven-plugin`) o Gradle.

**Checklist:** Corriges al menos un **code smell** y una **vulnerabilidad** de ejemplo en el vídeo.

## Para YouTube

- Mostrar el dashboard antes/después de un refactor pequeño.
