### Spring boot webflux demo

Sample of a Spring boot 3 app using webflux (for asynchronous stream processing with non-blocking back pressure).

Install proper java version:
```shell
sdk install java 17.0.6-amzn
```

Build with running tests:
```shell
./gradlew clean build
```

Start spring app:
```shell
./gradlew bootRun
```

Now hit:
```shell
curl http://localhost:8080/foo
```

```shell
curl http://localhost:8080/bar
```

ref:
- https://spring.io/guides/gs/reactive-rest-service/
- https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html
- https://www.reactive-streams.org/
