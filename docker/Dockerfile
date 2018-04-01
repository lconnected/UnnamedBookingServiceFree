FROM openjdk:8-jdk-alpine
MAINTAINER Lev Khrushchev <levas1992@gmail.com>

ENV CONFIG_DIR $APP_DIR/conf

WORKDIR /app
ADD jar/booking-app-*.jar booking-app.jar
ADD config/. $CONFIG_DIR

# Embed Tomcat default
VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","booking-app.jar"]

# share application port
EXPOSE 8080