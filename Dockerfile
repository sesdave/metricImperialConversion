FROM openjdk:8
EXPOSE 8081
ADD target/ImperialMetricConverter.jar ImperialMetricConverter.jar
ENTRYPOINT ["java","-jar","/ImperialMetricConverter.jar"]