FROM openjdk
WORKDIR /src
COPY ./ .
RUN ./gradlew jar
CMD java -jar build/libs/day02-1.0.jar