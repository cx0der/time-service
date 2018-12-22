# Timestamp Microservice

Microservice to convert between Unix time and Human readable time. Given a unix time like `1534032000000` the service 
will convert to a human readable form like `Sun Aug 12 00:00:00 UTC 2018`.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Run the Microservice only requirement is Docker. To develop and test

* Favorite text editor for IDE
* JDK 1.8 or Later
* Gradle 5+

```
$ git clone https://github.com/cx0der/time-service
$ cd time-service
$ ./gradlew build
```

## Running the tests

Run tests using

```
$ ./gradlew test
```

## Deployment

Follow these steps to build the application, docker image and run the docker image

```
$ ./gradlew build
$ docker build --build-arg JAR_FILE=build/libs/timeservice-1.0.0.jar -t timeservice .
$ docker run -t --rm -p 8080:8080 timeservice
```

These should get the Docker container running. Open up another terminal and run

```
$ curl "http://localhost:8080/timestamp/1534032000000"
```

And our microservice should respond back with

```
{"utc":"Sun Aug 12 00:00:00 UTC 2018","unixTime":1534032000000}%
```

## Built With

* [Spring Boot](https://spring.io/) - The web framework used
* [gradle](https://gradle.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Used to generate RSS Feeds

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Inspired from the Microservices project defined in [FreeCodeCamp](https://learn.freecodecamp.org/apis-and-microservices/apis-and-microservices-projects/timestamp-microservice)
