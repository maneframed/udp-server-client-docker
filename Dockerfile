FROM java:8
COPY server/build/libs/server.jar app.jar

CMD ["java", "-jar", "app.jar"]