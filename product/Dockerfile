FROM maven:3.8.6-amazoncorretto-17 AS maven
WORKDIR /app
COPY . .
RUN mvn package
RUN mvn clean install
EXPOSE 8081
CMD [ "mvn", "spring-boot:run" ]

