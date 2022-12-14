# ImperialMetric Unit Conversion Spring Boot Rest API 

Build Restful CRUD API for Conversion between Metric and Imperial Units using Spring Boot.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x


## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/sesdave/metricImperialConversion.git
```

+ open `src/main/resources/application.properties`

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/ImperialMetricConverter-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8081>.

## Explore Rest APIs

The app defines following APIs.

    GET /api/convert?value=3&unit=celcius

    
    

You can test them using postman or any other rest client.

## Postman Document

document is published on postman and url is -

<https://documenter.getpostman.com/view/7170305/VUqptxpf/>
