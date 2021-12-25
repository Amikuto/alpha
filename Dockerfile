FROM openjdk:17-alpine3.14
EXPOSE 8080

WORKDIR /
COPY build/libs/alpha.jar alpha.jar
CMD ["java", "-jar", "alpha.jar"]