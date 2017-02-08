FROM java:8
ADD add_1.tar /
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/qt-msq.jar"]
