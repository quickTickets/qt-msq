FROM java:8
ADD qt-msq-0.1.0.jar /
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
