## Rate limit pattern with spring boot

In this project, I would like to demo Rate Limit pattern, one of the microservice design patterns for designing highly
resilient Microservices using a library called bucket4j along with Spring Boot.

## 🚀 How to execute

```shell
mvn spring-boot:run
```

## ✨ How to use

- get all by user:

```shell

# Without auth
curl --location --request GET 'http://localhost:8080/messages'

# With basic authentication
curl --location --request GET 'http://localhost:8080/messages' \
--header 'Authorization: Basic am9hbzoxMjM0NTY='
```

- post create message

```shell
  curl --location --request POST 'http://localhost:8080/messages' \
  --header 'Authorization: Basic am9hbzoxMjM0NTY=' \
  --header 'Content-Type: application/json' \
  --data-raw '{ "content": "Test Message 123" }'
```
