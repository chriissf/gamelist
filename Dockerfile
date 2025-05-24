# Etapa 1: Build com Maven + JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS compilação

WORKDIR /app

COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime JDK 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
