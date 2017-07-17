FROM java:8
COPY server/build/libs/server.jar app.jar

EXPOSE 4445/udp

CMD ["java", "-jar", "app.jar"]