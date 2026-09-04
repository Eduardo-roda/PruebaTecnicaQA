# language: es
@web
Característica: Búsqueda dentro del sitio
  Como visitante del sitio selenium.dev
  Quiero poder buscar contenido usando el buscador del sitio
  Para encontrar rápidamente la documentación relevante a mi consulta

  Antecedentes:
    Dado que Jorge visita la página de inicio de "https://selenium.dev"

  Esquema del escenario: Los resultados de búsqueda corresponden al término buscado
    Cuando Jorge busca el término "<termino_busqueda>"
    Entonces debería ver al menos un resultado
    Y cada resultado mostrado debería estar relacionado con "<termino_busqueda>"

    Ejemplos:
      | termino_busqueda |
      | WebDriver        |
      | Grid             |
