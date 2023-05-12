FROM openjdk:8-jdk-alpine
VOLUME /tmp
# Add the application's jar to the container
COPY /*.jar config-server.jar

RUN mkdir  config-server-configuration
COPY  /config-server-app-config.yml /config-server-configuration/config-server-app-config.yml

RUN mkdir  applications-configuration
COPY  /test-configuration.yml /applications-configuration/test-configuration.yml

# openjdk:8-jdk-alpine'da bash yok sh var. docker-compose.yml'da CMD'de bash'a ihtiyacımız var.
RUN apk add --no-cache bash

ENTRYPOINT ["java", "-jar", "-Dspring.config.location=file:/config-server-configuration/config-server-app-config.yml", "/config-server.jar"]