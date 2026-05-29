FROM alpine/java:21-jre

COPY target/*.java /app/app.java
WORKDIR /app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.java"]
