# language: es
@web
Característica: Carga de la página de inicio de Selenium
  Como visitante del sitio selenium.dev
  Quiero que la página de inicio cargue correctamente
  Para confirmar que el sitio está disponible y muestra el contenido esperado

  Escenario: La página de inicio carga y muestra el título esperado
    Dado que Jorge visita la página de inicio de "https://selenium.dev"
    Entonces la página debería mostrar el título "Selenium"
