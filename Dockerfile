FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/uniapp-0.0.1.jar /uniapp-0.0.1.jar
EXPOSE 8080
CMD ["java","-jar","uniapp-0.0.1.jar"]