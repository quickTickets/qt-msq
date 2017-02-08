FROM java:8
VOLUME /tmp
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /qt-msq-0.1.0.jar" ]
