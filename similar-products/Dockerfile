FROM gradle:8.7.0-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "app.jar"]
