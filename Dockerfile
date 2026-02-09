# Use Eclipse Temurin JDK 17 with Alpine
FROM eclipse-temurin:17-jdk-alpine

# Install Maven for building the jar
RUN apk add --no-cache maven

# Set working directory
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the jar inside Docker
RUN mvn clean package -DskipTests

# Copy the built jar
COPY target/expense_tracker-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]