# Tienes que tener buildeado el proyecto usar [mvn clean install -DskipTests]
# FROM openjdk:17-alpine
# LABEL authors="ecortez"

# RUN mkdir /conf

# COPY target/core-service-*.jar /app.jar

# ENTRYPOINT exec java -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=/conf/application.yml
# -------------------------------------------------------------------------------
FROM eclipse-temurin:17-jdk AS builder

LABEL authors="ecortez"

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]