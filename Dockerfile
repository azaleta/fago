FROM maven:3.8.5-amazoncorretto-17 as builder
WORKDIR /usr/src/app
COPY pom.xml .
COPY ./src ./src
# package jar
RUN mvn clean package

FROM amazoncorretto:17
COPY --from=builder /usr/src/app/target/fago-0.0.1-SNAPSHOT.jar fago-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "fago-0.0.1-SNAPSHOT.jar"]
