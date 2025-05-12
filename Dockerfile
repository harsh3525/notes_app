FROM amazoncorretto:17-alpine-jdk
COPY target/notes-0.0.1-SNAPSHOT.jar notes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/notes-0.0.1-SNAPSHOT.jar"]