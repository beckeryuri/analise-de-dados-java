FROM openjdk:12-alpine

WORKDIR /home/becker/data/in
WORKDIR /home/becker/data/out

EXPOSE 8082

COPY analise-de-dados-java-0.0.1-SNAPSHOT.jar /analise.jar

CMD ["java", "-jar", "/analise.jar"]
