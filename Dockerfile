FROM openjdk:17
RUN mkdir -p /home/apps
COPY . /home/apps
WORKDIR /home/apps
ENTRYPOINT ["java","-jar","target/scientificCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar"]
