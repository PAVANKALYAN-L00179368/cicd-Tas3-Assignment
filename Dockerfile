FROM openjdk:19-jdk-alpine3.16

LABEL mentainer="pavanvarikolu@gmail.com"

WORKDIR /app

COPY target/*.war /app/springbootApp.war

ENTRYPOINT ["java", "-jar", "springbootApp.war"]