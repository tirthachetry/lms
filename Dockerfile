# Use OpenJDK as base image
FROM openjdk:17-jdk-slim

# Add JAR file to container
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
