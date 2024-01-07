FROM eclipse-temurin:17

MAINTAINER jefferson.com

COPY target/crud-Api-Rest-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]