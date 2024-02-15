ARG BASE_IMAGE=openjdk:11
FROM ${BASE_IMAGE}
MAINTAINER ciandt.com
WORKDIR /app
COPY target/produtos-ms-0.0.1-SNAPSHOT.jar produtos-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/produtos-ms-0.0.1-SNAPSHOT.jar"]