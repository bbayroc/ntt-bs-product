FROM amazoncorretto:11-alpine-jdk
MAINTAINER bayro
COPY target/Product-0.0.1-SNAPSHOT.jar /Product.jar
ENTRYPOINT ["java","-jar","/Product.jar"]

