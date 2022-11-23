# Spring-Boot
## Documentacion servicios REST

Para poder testear la aplicacion se debe utilizar el link de heroku el cual accede a la aplicacion.

```
https://entregable5.herokuapp.com/
```
A continuacion para acceder a cualquier endpoint se debe ingresar al siguiente link el cual contiene la lista detallada de cada endpoint de la aplicacion.
```
https://entregable5.herokuapp.com/swagger-ui/index.html
```
Como ejemplo se proporciona a continuacion el curl y la request URL de la consulta que muestra la lista de estudiantes ordenados por apellido.
- CURL
```
curl -X 'GET' \
  'https://entregable5.herokuapp.com/estudiantes' \
  -H 'accept: application/json'
```
- Request URL
```
https://entregable5.herokuapp.com/estudiantes
```
