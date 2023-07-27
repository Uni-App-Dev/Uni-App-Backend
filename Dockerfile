FROM openjdk:17.0.2
EXPOSE 8080
ADD target/uni-app.jar uni-app.jar
ENTRYPOINT ["java","-jar","uni-app.jar"]