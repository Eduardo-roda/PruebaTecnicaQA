# language: es
@api
Característica: Actualización de un usuario vía API
  Como consumidor de la API de reqres.in
  Quiero poder actualizar los datos de un usuario existente
  Para validar que el servicio refleja correctamente los cambios enviados

  Escenario: Actualizar el nombre y el puesto de un usuario existente
    Dado que el Cliente API está listo para interactuar con "https://reqres.in"
    Cuando el Cliente API actualiza al usuario con id 2 con el nombre "Jorge Ramirez" y el puesto "QA Lead"
    Entonces la respuesta debería tener el código de estado 200
    Y la respuesta debería contener el nombre "Jorge Ramirez" y el puesto "QA Lead"
    Y la respuesta debería contener una fecha de actualización "updatedAt"
