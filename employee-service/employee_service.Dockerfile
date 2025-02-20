#Start with a base image containing Java runtime
#FROM openjdk:17-jdk-slim
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#Maven Build
FROM maven:latest AS build
COPY employee-service/src /usr/src/app/src
COPY employee-service/pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

#Java & Jar Package
FROM eclipse-temurin:17
COPY --from=build /usr/src/app/target/*.jar /usr/app/employee-service.jar
ENTRYPOINT [ "java","-jar","/usr/app/employee-service.jar" ]
