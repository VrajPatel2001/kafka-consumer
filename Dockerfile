FROM openjdk:17-oracle
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
EXPOSE 8002
# ENTRYPOINT exec java $JAVA_OPTS -jar consumer.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar consumer.jar
