FROM azul/zulu-openjdk-alpine:11 as packager
VOLUME /tmp
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]
