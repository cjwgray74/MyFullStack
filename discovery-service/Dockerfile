#FROM maven:latest AS build
#COPY discovery-service/src /usr/src/app/src
#COPY discovery-service/pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests
#
#FROM eclipse-temurin:17
#COPY --from=build /usr/src/app/target/*.jar /usr/app/discovery-service.jar
#ENTRYPOINT [ "java","-jar","/usr/app/discovery-service.jar" ]
FROM eclipse-temurin:17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]