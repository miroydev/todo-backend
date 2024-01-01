FROM openjdk:21


# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by Gradle into the container
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

ENV PORT 8080

# Expose the port application will run on
EXPOSE 8080


# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
