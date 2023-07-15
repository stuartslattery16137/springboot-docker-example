FROM openjdk:17-jdk-slim
COPY /target/test-0.0.1-SNAPSHOT.jar /target/test.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","C:/Users/stuar/Documents/test.jar"]