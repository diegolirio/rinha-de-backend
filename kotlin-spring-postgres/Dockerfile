FROM openjdk:17-jdk-slim

EXPOSE 8080
RUN mkdir /app
COPY build/libs/app.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]