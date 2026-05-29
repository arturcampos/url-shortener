FROM alpine/java:21-jre
WORKDIR /app
COPY ./target/*.java app.java
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.java"]
