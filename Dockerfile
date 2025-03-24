# Usar la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Maven
COPY target/*.jar app.jar

# Exponer el puerto en el que corre Spring Boot
EXPOSE 8081

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
