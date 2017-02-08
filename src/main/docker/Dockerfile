FROM java:8
VOLUME /tmp
ADD qt-msq-0.1.0.jar app.jar
RUN bash -c 'touch /qt-msq-0.1.0.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
