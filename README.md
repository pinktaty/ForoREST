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
- `./src/main/java/com/pinktaty/foroREST/CorsConfiguration.java`: Class that configures the Cross-Origin Resource Sharing (CORS) policy for the API.

### Controllers
- `./src/main/java/com/pinktaty/foroREST/controller/AutenticacionController.java`: REST controller responsible for handling login requests, authenticating users, and generating JWT tokens for authenticated requests.
- `./src/main/java/com/pinktaty/foroREST/controller/CursoController.java`: REST controller handling requests related to courses.
- `./src/main/java/com/pinktaty/foroREST/controller/TopicoController.java`: REST controller managing operations related to discussion topics.

### Domains

#### User
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/Usuario.java`: Class representing the Usuario (user) entity in the database using JPA (Java Persistence API).
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/AutenticacionUsuario.java`: Record encapsulating the necessary data for user authentication.
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/UsuarioRepository.java`: Interface extending JpaRepository from Spring Data JPA, allowing management of the database with available users for the authentication process.

#### Course
- `./src/main/java/com/pinktaty/foroREST/domain/curso/Curso.java`: Class representing the Curso (course) entity in the database.
- `./src/main/java/com/pinktaty/foroREST/domain/curso/CursoService.java`: Service component providing methods to interact with courses, using CursoRepository to access the persistence layer.
- `./src/main/java/com/pinktaty/foroREST/domain/curso/CursoRepository.java`: Interface extending JpaRepository from Spring Data JPA, providing methods for CRUD operations and custom queries on the Curso entity.

### Topics

#### Topic
- `./src/main/java/com/pinktaty/foroREST/domain/topico/Topico.java`: Class defining the persistence entity Topico, representing a topic in the application.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/Estado.java`: Enum defining different possible states for a Topico.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/TopicoService.java`: Class responsible for handling business logic related to Topico entities.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/TopicoRespository.java`: Interface extending JpaRepository for managing Topico entities through database connections.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosRegistroTopico.java`: Record encapsulating the necessary data to register a new Topico in the application.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosRespuestaTopico.java`: Record encapsulating the response data of a Topico to be returned as a result of requests to the application.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosActualizaTopico.java`: Record encapsulating the necessary data to update a Topico in the application.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosListadoTopico.java`: Record used to represent the data of a Topico in listing contexts.

### Infrastructure

#### Security
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityConfiguration.java`: Configuration file configuring security using Spring Security.
- `./src/main/java/com/pinktaty/foroREST/infra/security/DatosJWTToken.java`: Record encapsulating a jwtToken field, used to represent a JWT (JSON Web Token).
- `./src/main/java/com/pinktaty/foroREST/infra/security/TokenService.java`: Class handling the generation and verification of JWT tokens for authentication in the application.
- `./src/main/java/com/pinktaty/foroREST/infra/security/AutenticacionService.java`: Class implementing Spring Security's UserDetailsService responsible for loading user details based on the username.
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityFilter.java`: Custom Spring Security filter class designed to intercept incoming requests and verify the authenticity of JWT tokens in the Authorization header.

### Infrastructure

#### Security
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityConfiguration.java`: Configuration file that sets up security using Spring Security.
- `./src/main/java/com/pinktaty/foroREST/infra/security/DatosJWTToken.java`: Record encapsulating a jwtToken field, used to represent a JWT (JSON Web Token).
- `./src/main/java/com/pinktaty/foroREST/infra/security/TokenService.java`: Class responsible for generating and verifying JWT tokens for authentication in the application.
- `./src/main/java/com/pinktaty/foroREST/infra/security/AutenticacionService.java`: Class implementing Spring Security's UserDetailsService, responsible for loading user details based on the username.
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityFilter.java`: Custom Spring Security filter class designed to intercept incoming requests and verify the authenticity of JWT tokens in the Authorization header.

### Error Handling
- `./src/main/java/com/pinktaty/foroREST/infra/errores/TratadorErrores.java`: Global exception handler responsible for managing exceptions and returning appropriate responses based on the error type.

### Database Generation
- `./src/main/resources/db/migration`: Folder containing SQL scripts that, through Flyway Database Migration, generate the database used by the application.

## Observations

For the correct execution of the api, make sure to create a MySQL database named "foro" and add the username and password for managing it to the file
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
- `./src/main/java/com/pinktaty/foroREST/CorsConfiguration.java`: Clase que configura la política de Cross-Origin 
  Resource Sharing (CORS) para la API.

### Controladores
- `./src/main/java/com/pinktaty/foroREST/controller/AutenticacionController.java`: Controlador REST que se encarga 
  de recibir las solicitudes de inicio de sesión, autenticar a los usuarios y generar tokens JWT para las solicitudes autenticadas.
- `./src/main/java/com/pinktaty/foroREST/controller/CursoController.java`: Controlador REST que maneja las 
  solicitudes relacionadas con los cursos.
- `./src/main/java/com/pinktaty/foroREST/controller/TopicoController.java`: Controlador REST que maneja las 
  operaciones relacionadas con los tópicos de discusión.

### Dominios

#### Usuario
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/Usuario.java`: Clase que representa la entidad de 
  Usuario en la base de datos utilizando JPA (Java Persistence API).
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/AutenticacionUsuario.java`: Record que encapsula los datos 
  necesarios para la autenticación de un usuario.
- `./src/main/java/com/pinktaty/foroREST/domain/usuario/UsuarioRepository.java`: Interfaz que extiende JpaRepository de
  Spring Data JPA y que permite 
  manejar la 
  base de datos con los usuarios disponibles para el proceso de autenticación.

#### Curso
- `./src/main/java/com/pinktaty/foroREST/domain/curso/Curso.java`: Clase que representa la entidad Curso en la base de 
  datos.
- `./src/main/java/com/pinktaty/foroREST/domain/curso/CursoService.java`: Componente de servicio que proporciona 
  métodos para interactuar con los cursos, utilizando el repositorio CursoRepository para acceder a la capa de persistencia.
- `./src/main/java/com/pinktaty/foroREST/domain/curso/CursoRepository.java`: Interfaz que extiende JpaRepository de 
  Spring Data JPA y proporciona métodos para realizar operaciones CRUD y consultas personalizadas en la entidad 
  Curso.

#### Topico
- `./src/main/java/com/pinktaty/foroREST/domain/topico/Topico.java`: Clase que define la entidad de persistencia Topico 
  que 
  representa un tema en la aplicación.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/Estado.java`: Enum que define diferentes estados 
  posibles para un 
  Topico.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/TopicoService.java`: Clase que se encarga de manejar la 
  lógica de negocio relacionada con las entidades Topico.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/TopicoRespository.java`: Interfaz que extiende JpaRepository 
  para la gestión de entidades Topico por medio de la conexión a la base de datos.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosRegistroTopico.java`: Record que encapsula los datos 
  necesarios para registrar un nuevo Topico en la aplicación.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosRespuestaTopico.java`: Record que encapsula los datos de 
  respuesta de un Topico para ser devueltos como resultado de requests a la aplicación.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosActualizaTopico.java`: Record que encapsula los datos necesarios para actualizar un Topico en la aplicación.
- `./src/main/java/com/pinktaty/foroREST/domain/topico/DatosListadoTopico.java`: Record utilizado para representar 
  los datos de un Topico en el contexto de listados.

### Infraestructura

#### Seguridad
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityConfiguration.java`: Archivo de configuración 
  que configura la seguridad utilizando Spring Security.
- `./src/main/java/com/pinktaty/foroREST/infra/security/DatosJWTToken.java`: Record que encapsula un campo jwtToken, 
  utilizado para representar un token JWT (JSON Web Tokens).
- `./src/main/java/com/pinktaty/foroREST/infra/security/TokenService.java`: Clase que maneja la generación y 
  verificación de tokens JWT para la autenticación en la aplicación.
- `./src/main/java/com/pinktaty/foroREST/infra/security/AutenticacionService.java`: Clase que implementa UserDetailsService de Spring Security y se encarga de cargar los detalles del usuario a partir del nombre de usuario.
- `./src/main/java/com/pinktaty/foroREST/infra/security/SecurityFilter.java`: Clase filtro personalizado de Spring 
  Security diseñado para interceptar las solicitudes entrantes y verificar la autenticidad de los tokens JWT en el encabezado de autorización.

### Manejo de errores
- `./src/main/java/com/pinktaty/foroREST/infra/errores/TratadorErrores.java`: Manejador global de excepciones  que se encarga de manejar excepciones y devolver respuestas adecuadas según el tipo de error.

### Generación de base de datos
- `./src/main/resources/db/migration`: Carpeta que contiene scripts SQL que por medio de Flyway Database Migration 
  generan la 
  base de 
  datos a usar por la aplicación.

## Observaciones

Para una correcta ejecución de la api asegurarse de crear una base de datos MySQL llamada "foro" y agregar el 
usario y contraseña para manejarla al archivo
```bash
./src/main/resources/application.properties.
```