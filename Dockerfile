FROM maven:3-amazoncorretto-17-al2023 as build

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY . .

# Build the application
RUN mvn clean package -DskipTests

FROM gcr.io/distroless/java17-debian11
ARG JAR_FILE=target/*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]