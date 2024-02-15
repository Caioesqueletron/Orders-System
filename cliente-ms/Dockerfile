ARG BASE_IMAGE=openjdk:11
FROM ${BASE_IMAGE}
MAINTAINER ciandt.com
WORKDIR /app
COPY target/cliente-ms-0.0.1-SNAPSHOT.jar cliente-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/cliente-ms-0.0.1-SNAPSHOT.jar"]