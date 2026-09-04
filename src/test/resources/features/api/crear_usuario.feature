# language: es
@api
Característica: Creación de un usuario vía API
  Como consumidor de la API de reqres.in
  Quiero poder crear un nuevo usuario
  Para validar que el servicio persiste correctamente la información enviada

  Escenario: Crear un nuevo usuario con nombre y puesto
    Dado que el Cliente API está listo para interactuar con "https://reqres.in"
    Cuando el Cliente API crea un nuevo usuario llamado "Jorge Ramirez" con el puesto "QA Automation Engineer"
    Entonces la respuesta debería tener el código de estado 201
    Y la respuesta debería contener el nombre "Jorge Ramirez" y el puesto "QA Automation Engineer"
    Y la respuesta debería contener un "id" y una fecha de creación "createdAt"
