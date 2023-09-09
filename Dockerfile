FROM openjdk:11 as build
MAINTAINER tihomir@temporal.io
COPY target/replaydemo-workers-1.0.0.jar replaydemo-workers-1.0.0.jar
ENTRYPOINT ["java","-jar","/replaydemo-workers-1.0.0.jar"]