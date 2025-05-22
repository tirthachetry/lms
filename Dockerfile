# Step 1: Use OpenJDK as the base image
FROM openjdk:17-jdk-slim AS build

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy Gradle build files and dependencies
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Step 4: Build the application using Gradle
COPY . .
RUN ./gradlew build --no-daemon

# Step 5: Create a smaller image for the app
FROM openjdk:17-jdk-slim

# Step 6: Copy the built JAR from the previous stage
COPY --from=build /app/build/libs/*.jar /app.jar

# Step 7: Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Step 8: Expose the port the app will run on
EXPOSE 8080

