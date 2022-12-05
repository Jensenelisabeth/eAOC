FROM openjdk
WORKDIR /src
COPY ./ .
RUN ./gradlew jar
CMD java -jar build/libs/day04-1.0.jar