# Rick And Morty Tech Exercise

This Spring Boot App were created using [Spring Initialzr](https://start.spring.io/).

The used versions are:
- Java 17
- Spring Boot 2.7.4

To be able to consume the [Rick and Morty API](https://rickandmortyapi.com/documentation/) uses the
Java library that appears in the documentation: https://github.com/adrianoluis/rickandmortyapi-java,
installed as maven dependency.

The app is packaged per layer, having these packages available:
- config
- controller
- service
- dto
- exception

## Usage

Compile and install the app using: `./mvnw clean install`

Test the app using: `./mvnw verify`

Run the app using: `./mvnw spring-boot:run`

Once the app is executing the API will be available at `http://127.0.0.1:8080/api/v1/`

To consume the character appearance endpoint do:

`GET http://127.0.0.1:8080/api/v1/character/search-character-appearance?name=rick sanchez`

and should get something like:

````json
{
  "name": "Rick Sanchez",
  "episodes": [
    "Pilot",
    "Lawnmower Dog",
    "...",
  ],
  "firstAppearance": "2 diciembre 2013"
}
````

## ToDos

- Improve the way that consumes the Rick And Morty API, asyncronus? caching data? Persist in document DB (e.g MongoDB)?
- Implement some unit and integrated testing
