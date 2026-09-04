# language: es
@api
Característica: Listado de usuarios vía API
  Como consumidor de la API de reqres.in
  Quiero poder obtener el listado de usuarios
  Para validar que el servicio responde correctamente con la información esperada

  Escenario: Obtener el listado de usuarios de la página 2
    Dado que el Cliente API está listo para interactuar con "https://reqres.in"
    Cuando el Cliente API solicita el listado de usuarios de la página 2
    Entonces la respuesta debería tener el código de estado 200
    Y la respuesta debería contener un listado de usuarios no vacío
    Y cada usuario del listado debería tener los campos "id", "email", "first_name" y "last_name"
    Y el campo "page" de la respuesta debería ser 2
