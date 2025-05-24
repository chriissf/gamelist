# Usa JDK 17 (mude se necessário)
FROM eclipse-temurin:17-jdk

# Define o argumento que identifica o JAR
ARG JAR_FILE=target/*.jar

# Copia o JAR gerado para dentro da imagem
COPY ${JAR_FILE} app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
