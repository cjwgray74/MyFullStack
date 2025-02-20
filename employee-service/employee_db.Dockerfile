FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD pacman
ENV MYSQL_DATABASE employees
ENV MYSQL_PASSWORD pacman

# USE IF YOU WOULD LIKE TO INSERT DATA INTO DOCKER IMAGE
ADD ./employee-service/schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306

