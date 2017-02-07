FROM java:8
#VOLUME /tmp
ADD qt-msq-0.1.0.jar
EXPOSE 8080
RUN bash -c 'touch /qt-msq-0.1.0.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/qt-msq-0.1.0.jar"]