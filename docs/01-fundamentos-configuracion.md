# 1. Fundamentos y configuración avanzada

## Objetivos

- Dominar `application.properties` y `application.yml` y cuándo usar cada uno.
- Usar **perfiles** (`@Profile`) para dev, test y prod.
- Externalizar configuración con **Spring Cloud Config** (concepto y mínimo viable).
- Afinar el contenedor de Spring: `@Conditional`, `@Lazy`, `@Scope`.

## Prerrequisitos

- JDK 17+ y un proyecto Spring Boot creado con [Spring Initializr](https://start.spring.io/).

## Paso 1 — Repaso rápido Spring Boot

1. Crea un proyecto con **Spring Web** y **Spring Boot Actuator**.
2. Arranca la app y verifica `/actuator/health`.
3. Localiza `SpringApplication.run` y el paquete base de escaneo de componentes.

**Checklist:** App arranca, health OK, entiendes el árbol de paquetes.

## Paso 2 — Properties vs YAML

1. Copia tu configuración a `application.yml` (indentación con 2 espacios).
2. Documenta en comentarios qué hace cada clave crítica (`server.port`, `spring.application.name`).
3. Prueba **sobrescritura**: variable de entorno `SERVER_PORT=8081` y confirma el puerto.

**Checklist:** Sabes leer jerarquía YAML y mapear a propiedades de Spring.

## Paso 3 — Perfiles (`@Profile`)

1. Crea `application-dev.yml` y `application-prod.yml` con valores distintos (por ejemplo `logging.level.root`).
2. Arranca con `--spring.profiles.active=dev` y luego `prod`.
3. Anota un `@Bean` con `@Profile("dev")` y verifica que solo exista en dev.

**Checklist:** Perfiles activos y beans condicionados por perfil funcionan.

## Paso 4 — Externalización con Spring Cloud Config

1. En un segundo proyecto (o módulo), agrega **Spring Cloud Config Server**.
2. Sirve un `application.yml` desde Git local o `classpath:/config/`.
3. En el cliente, añade **Spring Cloud Config Client** y `spring.config.import=configserver:`.

**Checklist:** El cliente arranca leyendo propiedades del servidor de configuración.

**Nota:** Para YouTube, enseña primero el flujo “sin Config Server” y luego la migración en 5–10 minutos.

## Paso 5 — Beans avanzados

1. `@ConditionalOnProperty`: bean solo si existe `feature.x=true`.
2. `@Lazy`: inyecta un servicio pesado y muestra que no se instancia hasta el primer uso.
3. `@Scope("prototype")`: dos inyecciones del mismo bean y compara identidad.

**Checklist:** Puedes explicar en una frase cuándo usar cada anotación.

## Para el vídeo (opcional)

- Miniatura: “Spring Boot PRO: perfiles + Config”.
- Cierre: “En el siguiente capítulo: REST avanzado y OpenAPI”.
