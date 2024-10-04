FROM openjdk:17-jdk-slim
WORKDIR /app
ARG JAR_FILE=target/newjobplatform-0.0.1.jar
COPY ${JAR_FILE} app_newjobplatform.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_newjobplatform.jar"]