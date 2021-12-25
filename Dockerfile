FROM openjdk:11-slim
EXPOSE 8080

WORKDIR /
COPY build/libs/alpha.jar alpha.jar
CMD ["java", "-jar", "alpha.jar"]