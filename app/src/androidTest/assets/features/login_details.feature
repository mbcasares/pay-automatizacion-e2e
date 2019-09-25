# language: es

Característica: Ingresar detalles de login

  Esquema del escenario: Login fallido
    Dado Inicio el app
    Cuando Doy clic en el campo de usuario
    Y Ingreso un usuario "<usuario>"
    Y Espero unos segundos
    Y Doy clic en el campo de password
    Y Ingreso un password "<password>"
    Y Doy clic en el boton Continuar
    Entonces Espero ver la pantalla de Acceso Incorrecto

    Ejemplos:
      | usuario         | password |
      | usuariocorrecto |correcta|
      | estetambien     |claveigual|
      | admin           |admin|

