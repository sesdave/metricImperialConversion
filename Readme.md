# Spring Boot, MySQL, JPA, Hibernate Rest API 

Build Restful CRUD API for Iapl Robot application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/sesdave/iapl-robot.git
```

**2. Create Mysql database**
```bash
create database heroku_8be0d9ec475e341
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/iapl-robot-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:9191>.

## Explore Rest APIs

The app defines following APIs.

    GET /api/survivors
    
    POST /api/add_survivor

    PUT /api/api/update_location/{id}

    POST /api/make-report
    
    GET /api/percentage-infected
    
    GET /api/uninfected-survivors

    GET /api/uninfected-survivors

    GET /api/infected-survivors
    
    GET /api/robots

You can test them using postman or any other rest client.

## Postman Document

document is published on postman and url is -

<https://documenter.getpostman.com/view/7170305/UVsTriLS/>
