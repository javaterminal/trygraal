FROM openjdk:10-jdk-slim
MAINTAINER Rahman Usta
ENV shell="/opt/graalvm/bin/polyglot --shell"
#RUN apt-get update -y && apt-get install sudo vim -y
VOLUME /tmp
WORKDIR /opt/trygraal/
COPY ./graalvm-0.32 /opt/graalvm
COPY target/trygraal.jar .
CMD ["java","-jar","./trygraal.jar"]