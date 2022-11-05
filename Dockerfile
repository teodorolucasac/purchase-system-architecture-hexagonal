FROM openjdk:17-alpine
LABEL maintainer="lucasteodoroac@gmail.com"

ENV LANG C.UTF-8

RUN apk add --update bash

ADD target/*.jar /app/app.jar

CMD java -jar /app/app.jar $APP_OPTIONS