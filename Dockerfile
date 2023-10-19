# grade7, jdk11
FROM gradle:jdk20-jammy AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# jdk11
FROM openjdk:20-rc-jdk
COPY --from=build /app/build/libs/trip-memo.jar /trip-memo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/trip-memo.jar"]
