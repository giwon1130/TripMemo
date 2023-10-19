# grade7, jdk11
FROM adoptopenjdk/openjdk20:alpine-slim AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# jdk11
FROM openjdk:11-jre-slim
COPY --from=build /app/build/libs/trip-memo.jar /trip-memo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/trip-memo.jar"]
