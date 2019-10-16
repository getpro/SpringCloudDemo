FROM openjdk:8-jre

MAINTAINER ttzommed@foxmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /demo-api3

WORKDIR /demo-api3

EXPOSE 6010

ADD ./target/demo-api3-*.jar ./app.jar


CMD sleep 10;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar app.jar
