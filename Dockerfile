FROM openjdk:17
ADD ./scientificCalculator/target/scientificCalculator-1.0-SNAPSHOT.jar ./
WORKDIR ./
ENTRYPOINT ["java","-jar","/scientificCalculator-1.0-SNAPSHOT.jar"]
