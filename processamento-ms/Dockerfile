ARG BASE_IMAGE=openjdk:11
FROM ${BASE_IMAGE}
MAINTAINER ciandt.com
WORKDIR /app
COPY target/processamento-ms-0.0.1-SNAPSHOT.jar processamento-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/processamento-ms-0.0.1-SNAPSHOT.jar"]