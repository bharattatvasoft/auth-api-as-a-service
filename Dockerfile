FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
COPY ./target/partner-api-as-a-service-0.0.1-SNAPSHOT.jar /app
COPY dd-java-agent.jar elastic-apm-agent.jar /app/
EXPOSE 8999
