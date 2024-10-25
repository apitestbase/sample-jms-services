FROM eclipse-temurin:21.0.4_7-jre-alpine

ARG VERSION
ARG APP_DIR=/app
COPY target/sample-jms-services-${VERSION}.jar ${APP_DIR}/app.jar

WORKDIR ${APP_DIR}
ENTRYPOINT ["java", "-jar", "app.jar"]