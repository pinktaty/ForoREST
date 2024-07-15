# Fourth Oracle ONE Program's project

## Description

This project is a REST API application developed in Java with the Spring Framework. To test it, run the project and use a tool like 'Insomnia' or 'Postman'.

Note: this project is in spanish.

## Routes
Assuming the server is running on port 8080:
- `POST: http://localhost:8080/login`. Log in and authenticate as a user of the API. The available users with their respective passwords are [usuario, contraseña], [uno, dos], and [siii, nooo]. You can log in by sending a POST request with a JSON body containing the fields "nombre" (user) and "clave" (password). The response will be a JWT token, which you will need for any other request to the API.
- `GET: http://localhost:8080/cursos`. Check out the courses available for you to write topics about. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `POST: http://localhost:8080/topicos`. You can register a topic by sending a POST request with a JSON body containing the fields "titulo" (title), "mensaje" (content of the topic), and "cursoId" (ID of the course related to the topic). Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `GET: http://localhost:8080/topicos/{id}`. Search for a topic by its ID. The ID must be written without the {}. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `PUT: http://localhost:8080/topicos`. Update a topic by sending a JSON body containing the fields "id" (ID of the topic to change, this is the only mandatory field), "titulo" (new title), "mensaje" (new message), and "cursoId" (ID of the new course). Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `GET: http://localhost:8080/topicos`. List all active topics. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `GET: http://localhost:8080/topicos/curso/{id}`. Search for topics using their course ID. The ID must be written without the {}. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `DELETE: http://localhost:8080/topicos/{id}`. "Delete" a topic using its ID. The ID must be written without the {}. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.
- `GET: http://localhost:8080/topicos/todos`. List all topics, including the deleted (inactive) ones. Don't forget to add your JWT token to the Auth field as a 'Bearer Token'.

## Structure
- `./src/main/java/com/pinktaty/foroREST/ForoRestApplication.java`: Program's entry point.

## Observations

For the correct execution of the api, make sure to create a MySQL database named "foro" and add the username 
and password for managing it to the file
```bash
./src/main/resources/application.properties.
```

* * *

# Proyecto 04 del programa Oracle ONE

## Descripción

Este proyecto es una aplicación de API REST desarrollada en Java con el framework Spring. Para usarla ejecuta el 
proyecto y utiliza una herramienta como 'Insomnia' o 'Postman'.

## Rutas
Asumiendo que el servidor se está ejecutando en el puerto 8080:
- `POST: http://localhost:8080/login`. Inicia sesión y autentícate como un usuario de la API. Los usuarios disponibles con sus respectivas contraseñas son [usuario, contraseña], [uno, dos] y [siii, nooo]. Puedes iniciar sesión enviando una solicitud POST con un cuerpo JSON que contenga los campos "nombre" (usuario) y "clave" (contraseña). La respuesta será un token JWT, el cual necesitarás para cualquier otra solicitud a la API.
- `GET: http://localhost:8080/cursos`. Consulta los cursos disponibles para escribir temas. No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `POST: http://localhost:8080/topicos`. Puedes registrar un tema enviando una solicitud POST con un cuerpo JSON que contenga los campos "titulo" (título), "mensaje" (contenido del tema) y "cursoId" (ID del curso relacionado con el tema). No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `GET: http://localhost:8080/topicos/{id}`. Busca un tema por su ID. El ID debe escribirse sin los {}. No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `PUT: http://localhost:8080/topicos`. Actualiza un tema enviando un cuerpo JSON que contenga los campos "id" (ID del tema a cambiar, este es el único campo obligatorio), "titulo" (nuevo título), "mensaje" (nuevo mensaje) y "cursoId" (ID del nuevo curso). No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `GET: http://localhost:8080/topicos`. Lista todos los temas activos. No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `GET: http://localhost:8080/topicos/curso/{id}`. Busca temas usando el ID del curso. El ID debe escribirse sin los {}. No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `DELETE: http://localhost:8080/topicos/{id}`. "Elimina" un tema usando su ID. El ID debe escribirse sin los {}. No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.
- `GET: http://localhost:8080/topicos/todos`. Lista todos los temas, incluidos los eliminados (inactivos). No olvides agregar tu token JWT en el campo Auth como 'Bearer Token'.

## Estructura
- `./src/main/java/com/pinktaty/foroREST/ForoRestApplication.java`: Punto de entrada del programa.

## Observaciones

Para una correcta ejecución de la api asegurarse de crear una base de datos MySQL llamada "foro" y agregar el 
usario y contraseña para manejarla al archivo
```bash
./src/main/resources/application.properties.
```
