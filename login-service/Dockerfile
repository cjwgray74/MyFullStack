#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY target/YOUR-APP-JAR-FILE-0.0.1-SNAPSHOT.jar YOUR-APP-JAR-FILE.jar
#ENTRYPOINT ["java","-jar","YOUR-APP-JAR-FILE.jar"]

#Maven Build
#FROM maven:latest AS build
#COPY login-service/src /usr/src/app/src
#COPY login-service/pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

#Java & Jar Package
#FROM eclipse-temurin:17
#COPY --from=build /usr/src/app/target/*.jar /usr/app/login-service.jar
#ENTRYPOINT [ "java","-jar","/usr/app/login-service.jar" ]
FROM eclipse-temurin:17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]