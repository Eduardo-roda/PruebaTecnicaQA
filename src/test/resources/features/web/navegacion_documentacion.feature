# language: es
@web
Característica: Navegación al apartado de Documentation
  Como visitante del sitio selenium.dev
  Quiero poder navegar a la sección de Documentation desde el menú principal
  Para acceder a la documentación oficial del proyecto

  Antecedentes:
    Dado que Jorge visita la página de inicio de "https://selenium.dev"

  Escenario: La navegación a Documentation carga la página esperada
    Cuando Jorge hace clic en el enlace "Documentation" del menú de navegación
    Entonces Jorge debería ser dirigido a una página cuya URL contiene "/documentation"
    Y la página de documentación debería mostrar contenido visible
