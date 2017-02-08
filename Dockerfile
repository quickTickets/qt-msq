FROM java:8
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/qt-msq.jar"]
