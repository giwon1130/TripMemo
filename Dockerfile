# grade7, jdk11
FROM gradle:8.4.0-jdk21-jammy AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# jdk11
FROM openjdk:21-jdk
COPY --from=build /app/build/libs/trip-memo.jar /trip-memo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/trip-memo.jar"]
