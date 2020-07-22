FROM photon:3.0
RUN apk add openjdk8
COPY target/course-0.0.1-SNAPSHOT.jar sample.jar
ENTRYPOINT ["java","-jar","sample.jar"]
