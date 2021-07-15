FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-alpine-slim
RUN apk update
RUN apk upgrade
RUN apk add nano
RUN apk add ca-certificates && update-ca-certificates
RUN apk add --update tzdata
ENV TZ=America/Tijuana
RUN rm -fr /var/cache/apk/*
# copy jar file into container image under app directory
COPY api-0.0.1-SNAPSHOT.jar api-solucion.jar
# expose server port accept connections
#EXPOSE 8282
# start application
CMD ["java", "-jar", "api-solucion.jar"]
