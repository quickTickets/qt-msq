FROM java:8
RUN sh -c 'touch /qt-msq-0.1.0.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /qt-msq-0.1.0.jar" ]
