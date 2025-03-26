#FROM maven:latest AS build
#COPY api-gateway/src /usr/src/app/src
#COPY api-gateway/pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests
#
##Java & Jar Package
#FROM eclipse-temurin:17
#COPY --from=build /usr/src/app/target/*.jar /usr/app/api-gateway.jar
#ENTRYPOINT [ "java","-jar","/usr/app/api-gateway.jar" ]
FROM eclipse-temurin:17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]