FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /app

COPY ./ ./

RUN apk update && apk add maven

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/GestionLogin-0.0.1-SNAPSHOT.jar", "-Dspring-boot.run.profiles=mysql"]