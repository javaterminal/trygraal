FROM openjdk:10-jdk-slim
MAINTAINER Rahman Usta
ENV shell="/opt/graalvm/bin/polyglot --shell"
#RUN apt-get update -y && apt-get install sudo vim -y
VOLUME /tmp
WORKDIR /opt/trygraal/
COPY ./graalvm-0.32 /opt/graalvm
COPY target/trygraal.jar .
RUN useradd -ms /bin/bash trygraal
RUN chmod -R  a+x /opt/graalvm/bin/polyglot || true
USER trygraal
CMD ["java","-jar","./trygraal.jar"]