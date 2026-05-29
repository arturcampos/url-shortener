FROM alpine/java:21-jre
WORKDIR /app
COPY ./target/*.java app.java

ENTRYPOINT ["java", "-jar", "app.java"]
