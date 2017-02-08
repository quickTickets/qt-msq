FROM java:8
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/qt-msq-0.1.0.jar"]
