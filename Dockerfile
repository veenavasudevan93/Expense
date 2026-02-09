# Use official OpenJDK image
#FROM openjdk:17-jdk-alpine
FROM eclipse-temurin:17-jdk-alpine


# Set working directory inside container
WORKDIR /app

# Copy the jar file into container
COPY target/expense_tracker-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app uses
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "app.jar"]