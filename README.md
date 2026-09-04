# Prueba Técnica QA Automatizado Senior — Serenity BDD + Screenplay + Cucumber

Suite de pruebas automatizadas que cubre los 6 casos de prueba solicitados:

| # | Tipo | Caso de prueba | Feature file |
|---|------|-----------------|--------------|
| 1 | Web | Carga de la home de `selenium.dev` y validación del título | `features/web/pagina_inicio.feature` |
| 2 | Web | Navegación al apartado "Documentation" | `features/web/navegacion_documentacion.feature` |
| 3 | Web | Flujo de búsqueda en el sitio | `features/web/busqueda.feature` |
| 4 | API | Listado de usuarios (`reqres.in`) | `features/api/listar_usuarios.feature` |
| 5 | API | Creación de un usuario | `features/api/crear_usuario.feature` |
| 6 | API | Actualización de un usuario | `features/api/actualizar_usuario.feature` |

## Stack técnico

- **Lenguaje:** Java 25
- **Framework:** Serenity BDD 4.2.5
- **Patrón de diseño:** Screenplay (`serenity-screenplay`, `serenity-screenplay-webdriver`, `serenity-screenplay-rest`, `serenity-ensure`)
- **Definición de pruebas:** Cucumber 7 (Gherkin en español)
- **Gestor de dependencias:** Maven
- **Reportes:** Serenity BDD (living documentation)

## Estructura del proyecto

```
qa-automation-screenplay/
├── pom.xml
├── src/test/resources/
│   ├── serenity.conf
│   └── features/
│       ├── web/        (Casos 1, 2 y 3)
│       └── api/        (Casos 4, 5 y 6)
└── src/test/java/com/automation/qa/
    ├── runners/                 -> CucumberTestSuite (punto de entrada)
    ├── hooks/                   -> ciclo de vida del Stage/Cast de Screenplay
    ├── config/                  -> lectura de URLs/API key configurables
    ├── model/                   -> POJOs usados como payload de la API
    ├── stepdefinitions/
    │   ├── web/                 -> steps de los casos 1, 2 y 3
    │   └── api/                 -> steps de los casos 4, 5 y 6
    └── screenplay/
        ├── web/
        │   ├── userinterface/   -> Targets (equivalente a Page Objects)
        │   ├── tasks/           -> Tasks (acciones de alto nivel)
        │   └── questions/       -> Questions (consultas al estado de la UI)
        └── api/
            ├── tasks/           -> Tasks (llamadas HTTP)
            └── questions/       -> Questions (lectura de la respuesta HTTP)
```

Cada capa tiene una única responsabilidad (principio Screenplay):
**Actors** (`Jorge`, `Cliente API`) ejecutan **Tasks**, las Tasks usan
**Interactions** sobre elementos definidos en **Targets**, y las
verificaciones se hacen a través de **Questions**. Esto permite que los
step definitions permanezcan legibles y desacoplados de los detalles de
implementación (selectores CSS, endpoints, etc.).

## Requisitos previos

1. **Java 25+** y **Maven 3.9+** instalados.
2. **Google Chrome** instalado (Selenium Manager descarga el driver
   automáticamente — no es necesario instalar ChromeDriver a mano).
3. Una **API key gratuita de reqres.in**, obligatoria desde 2025 para
   cualquier request a `/api/*`:
   1. Regístrate gratis en <https://app.reqres.in>.
   2. Copia tu API key.
   3. Expórtala como variable de entorno antes de ejecutar las pruebas:
      ```bash
      export REQRES_API_KEY="tu-api-key-aqui"
      ```
      (En Windows PowerShell: `$env:REQRES_API_KEY="tu-api-key-aqui"`)
      `free_user_3ImgoLviKZYp3i6yABiSg2zOeph`

   También puede pasarse por línea de comandos con `-Dapi.key=...`, sin
   necesidad de exportar la variable de entorno. **La clave nunca debe
   subirse al repositorio.**

## Cómo ejecutar las pruebas

Ejecutar toda la suite (web + API):

```bash
mvn clean verify
```

Ejecutar solo las pruebas Web:

```bash
mvn clean verify -Dtags="@web"
```

Ejecutar solo las pruebas de API:

```bash
mvn clean verify -Dtags="@api"
```

Ejecutar en modo visible (no headless), útil para depurar localmente:

```bash
mvn clean verify -Dheadless.mode=false
```

Apuntar a otro entorno (por ejemplo, un mock/staging):

```bash
mvn clean verify -Dweb.base.url=https://www.selenium.dev -Dapi.base.url=https://reqres.in
```

## Cómo revisar los reportes

Serenity BDD genera un reporte HTML (living documentation) tras cada
ejecución, agregando resultados de pruebas web y de API en un solo
informe:

```
target/site/serenity/index.html
```

Ábrelo directamente en el navegador, o publícalo como artefacto de tu
pipeline de CI/CD (GitHub Actions, GitLab CI, Jenkins, etc.) para
compartir el enlace con el equipo evaluador.

## Notas de diseño y decisiones técnicas

- **Runner único (`CucumberTestSuite`)** con Serenity + Cucumber vía JUnit4
  (`CucumberWithSerenity`), que es el runner recomendado y más estable de
  Serenity BDD 4.x para proyectos que combinan Web + API en un mismo
  reporte.
- **Idioma de los features:** los `.feature` están escritos en español
  (`# language: es`) para que sean legibles por perfiles no técnicos, tal
  como pide el enunciado, manteniendo el código Java en inglés/estándar.
- **Selectores del buscador de `selenium.dev`:** el sitio utiliza Algolia
  DocSearch. Los selectores usados en `SearchComponent` (clases
  `DocSearch-*`) son los estándar de esa librería; si el sitio cambiara de
  proveedor de búsqueda, solo hace falta actualizar esa clase — ninguna
  otra capa del framework se ve afectada.
- **API key de reqres.in:** desde el relanzamiento 2025 del servicio, todo
  endpoint de `/api/*` exige la cabecera `x-api-key`. Esto se gestiona de
  forma centralizada en `EnvironmentConfig.apiKey()`, leyendo la variable
  de entorno `REQRES_API_KEY` (o `-Dapi.key=...`), nunca hardcodeada.
- **Cobertura de casos borde** contemplada en el diseño (ampliable):
  - Búsqueda con `Esquema del escenario` (Scenario Outline) para probar
    varios términos sin duplicar steps.
  - Verificación de campos obligatorios en la respuesta de la API
    (`id`, `email`, `first_name`, `last_name`, `createdAt`, `updatedAt`).
  - Separación de Tasks/Questions permite añadir nuevos escenarios
    (por ejemplo, búsqueda sin resultados, creación con campos vacíos,
    actualización de un usuario inexistente) reutilizando la
    infraestructura ya creada.

## Siguientes pasos sugeridos (fuera del alcance de esta entrega)

- Integrar la ejecución en un pipeline de CI (GitHub Actions) que publique
  el reporte de Serenity como artefacto o vía GitHub Pages.
- Ejecución en paralelo por navegador (Chrome/Firefox) usando los
  perfiles de Maven.
- Añadir pruebas negativas explícitas (usuario inexistente en `GET
  /api/users/23`, búsqueda sin resultados, etc.).
