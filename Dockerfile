FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","target/test.jar"]
EXPOSE 8081