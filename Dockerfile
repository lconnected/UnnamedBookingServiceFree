FROM openjdk:8-jdk-alpine
MAINTAINER Lev Khrushchev <levas1992@gmail.com>
WORKDIR /app
#ARG JAR_FILE
ADD ./booking-app-1.0.jar booking-app.jar
#ADD . /app
VOLUME /tmp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/booking-app.jar"]
EXPOSE 8080