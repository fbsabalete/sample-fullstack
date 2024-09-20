FROM amazoncorretto:17

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /deployments/app.jar
ENTRYPOINT ["java", "-jar", "/deployments/app.jar"]
EXPOSE 8080