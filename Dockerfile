# Etapa 1: Build com Maven + JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia todos os arquivos do projeto para o container
COPY . .

# Ajusta permissão para o wrapper do Maven
RUN chmod +x ./mvnw

# Executa o build, pulando os testes
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime com JDK 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
