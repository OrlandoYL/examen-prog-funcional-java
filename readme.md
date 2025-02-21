# CRUD de Student,Course, Tuition y TuitionDetail con Spring Boot y PostgreSQL

## Installation
Este proyecto esta creado con Spring Boot 3+ , PostgreSQL, Spring JPA, Lombok

## Database configuration
Existe el archivo data.sql para poder poblar los datos al levantar la aplicacion.
Configurar usuario y clave en el archivo application.properties

```
spring.application.name=orlando-yarasca
server.port=8080
spring.jpa.database=postgresql
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://localhost:5432/{name_db}
spring.datasource.username=
spring.datasource.password=
spring.sql.init.mode=always
spring.sql.init.continue-on-error=true
```

## Usage
Ejecute el proyecto a través del IDE y diríjase a [http://localhost:8080](http://localhost:8080)


## API Reference

#### Student Service

|HTTP Method| URL                                  | Description                |
|---|--------------------------------------|----------------------------|
|`POST`| http://localhost:8080/students          | Create new Student         |
|`PUT`| http://localhost:8080/students/{id} | Update Student by ID       |
|`GET`| http://localhost:8080/students/{id} | Get Student by ID          |
|`DELETE`| http://localhost:8080/students/{id}  | Delete Student by ID       |
|`GET`| http://localhost:8080/students       | Get All Students           |
|`GET`| http://localhost:8080/students/order/desc       | Get All Students by order  |

## Testing
1. `Create New Student`
- URL: http://localhost:8080/students
- HTTP Method: POST
- Body:
  ````json
    {
      "firstNameStudent": "Orlando Netty",
      "lastNameStudent": "Yarasca Lupuche",
      "nroDocumentStudent": "78754525",
      "ageStudent": 30
    }
  ````

#### Course Service

|HTTP Method| URL                                  | Description        |
|---|--------------------------------------|--------------------|
|`POST`| http://localhost:8080/courses          | Create new Course  |
|`PUT`| http://localhost:8080/courses/{id} | Update Course by ID |
|`GET`| http://localhost:8080/courses/{id} | Get Course by ID   |
|`DELETE`| http://localhost:8080/courses/{id}  | Delete Course by ID |
|`GET`| http://localhost:8080/courses       | Get All Courses    |

2. `Create New Course`
- URL: http://localhost:8080/courses
- HTTP Method: POST
- Body:
  ````json
    {
      "nameOfCourse": "Redes Cisco I",
      "acronymOfCourse": "RCISCOI",
      "statusOfCourse": true
    }
  ````

#### Tuition Service

|HTTP Method| URL                                  | Description                  |
|---|--------------------------------------|------------------------------|
|`POST`| http://localhost:8080/tuitions          | Create new Tuition           |
|`PUT`| http://localhost:8080/tuitions/{id} | Update Tuition by ID         |
|`GET`| http://localhost:8080/tuitions/{id} | Get Tuition by ID            |
|`DELETE`| http://localhost:8080/tuitions/{id}  | Delete Tuition by ID         |
|`GET`| http://localhost:8080/tuitions       | Get All Tuitions             |
|`GET`| http://localhost:8080/groupbycourseofstudents       | Get Student group by Course |


3. `Create New Tuitions`
- URL: http://localhost:8080/tuitions
- HTTP Method: POST
- Body:
  ````json
    {
      "student": {
       "idStudent": 3
      },
      "dateTime": "2025-03-01T09:02:15",
      "enabled": true,
      "details": [
      {
        "course": {
        "idCourse": 1
      },
      "classroom":"AULA A1"
      },
      {
        "course": {
        "idCourse": 2
      },
      "classroom":"AULA B1"
      },
      {
        "course": {
        "idCourse": 3
      },
      "classroom":"AULA C1"
      }
     ]
    }
  ````
