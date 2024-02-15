ARG BASE_IMAGE=openjdk:11
FROM ${BASE_IMAGE}
MAINTAINER ciandt.com
WORKDIR /app
COPY target/pedidos-ms-0.0.1-SNAPSHOT.jar pedidos-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/pedidos-ms-0.0.1-SNAPSHOT.jar"]