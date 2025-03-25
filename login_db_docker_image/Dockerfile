FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD pacman
ENV MYSQL_DATABASE logindb
ENV MYSQL_PASSWORD pacman

ADD /login_db_docker_image/schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306
