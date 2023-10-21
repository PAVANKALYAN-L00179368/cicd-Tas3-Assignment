FROM openjdk:19-jdk-alpine3.16

EXPOSE 8080

LABEL mentainer="pavanvarikolu@gmail.com"

WORKDIR /app

COPY target/*.war /app/springbootApp.war

ENTRYPOINT ["java", "-jar", "springbootApp.war"]
