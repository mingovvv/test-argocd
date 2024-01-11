# for build
FROM gradle:7.4.0-jdk17 AS build

WORKDIR /app
COPY build.gradle ./
COPY src ./src
RUN gradle clean build --no-daemon  --stacktrace --info --warning-mode all

# for runtime
FROM openjdk:17-jdk-slim AS runtime
ARG BRANCH
ENV SPRING_PROFILES_ACTIVE ${BRANCH}

WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "app.jar"]