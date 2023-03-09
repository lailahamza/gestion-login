FROM openjdk:11-jdk-slim
# Set the working directory to /app
#WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/GestionLogin-0.0.1-SNAPSHOT.jar GestionLogin-0.0.1-SNAPSHOT.jar
#COPY ./target/spring-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "GestionLogin-0.0.1-SNAPSHOT.jar"]

#