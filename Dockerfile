# Usa OpenJDK como base
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo
WORKDIR /app

# Copia el código fuente al contenedor
COPY . .

# Compila el proyecto
RUN ./mvnw clean package -DskipTests

# Copia el JAR generado al contenedor
RUN cp target/*.jar app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]

