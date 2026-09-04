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

- **Lenguaje:** Java 17
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

## Requisitos previos

1. **Java 17+** y **Maven 3.9+** instalados.
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
      (En Windows PowerShell: `$env:REQRES_API_KEY="free_user"`)
      `free_user_3ImgoLviKZYp3i6yABiSg2zOeph`


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

## Cómo revisar los reportes

```
target/site/serenity/index.html
```



