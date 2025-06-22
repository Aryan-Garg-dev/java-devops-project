# Stage 1: Build & Test Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Runtime Stage
FROM eclipse-temurin:21-jdk AS run
WORKDIR /app
COPY --from=build /app/target/arrayUtils-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
