#### MATIAS DEVIN 08-10-2020
workspace-spring-tool-suite-4-4.8.0.

Examen Backend Cash

## Requisitos
* Spring-tool-suite // Visual Studio Code
* MySQL
* XAMP / LAMP
* JDK 1.8
* Maven



-----------------------------------------
| Instalacion / Clonado de git 
-----------------------------------------
Abir XAMP / LAMP
http://localhost/phpmyadmin
Verificar que la base de datos no tenga contraseña de lo contrario cambiarlo modificarlo en el codigo.

Crear Bases de datos el localhost ejecutando el archivo db_cashonline.sql dentro de la carpeta instalacion
Instalacion/db_cashonline.sql



### Cloar Repositories
Clone el https://github.com/matiasdevin1982/Cashonline.git

Abrir y ejecutar el proyecto

Documentacion de las API y testing
Ingresar a la url:
http://localhost:8080/swagger-ui.html#/servicios-rest
http://localhost:8080/v2/api-docs
(si no funciona verificar que el puerto este libre, sino hay que cambiarlo)


## Metodos
****************************************************************
Method GET

Consulta de creditos - page / size obligatorios - id opcional
http://localhost:8080/loans?page={page}&size={size}&user_id={id}
http://localhost:8080/loans?page={page}&size={size}

Consulta de clientes
http://localhost:8080/users
http://localhost:8080/users/{id}

Ejemplos 

http://localhost:8080/loans?page=1&size=50&user_id=1
http://localhost:8080/loans?page=1&size=50
http://localhost:8080/users
http://localhost:8080/users/1

****************************************************************
Method POST
Alta en base de datos
http://localhost:8080/users
content-type:application/json
{
"email":"demo@constancy.com.ar",
"firstName":"Matias",
"lastName":"Devin"
}

****************************************************************
Method DELETE
Borrado de usuarios
http://localhost:8080/users/{id}

Borrado de creditos
http://localhost:8080/loans/{id}

Ejemplos 
http://localhost:8080/loans/1
http://localhost:8080/users/1
****************************************************************

Dudas +549 116-242-9310
Matias@contancy.com.ar
www.constancy.com.ar



