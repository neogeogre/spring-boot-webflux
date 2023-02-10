package com.example.springbootwebflux

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class Controller {

  fun foo(request: ServerRequest): Mono<ServerResponse> {
    return ServerResponse.ok().contentType(APPLICATION_JSON)
      .body(fromValue(Pojo("Foo, Spring webflux !")))
  }

  fun bar(request: ServerRequest): Mono<ServerResponse> {
    return ServerResponse.ok().contentType(APPLICATION_JSON)
      .body(fromValue(Pojo("Bar, Spring webflux !")))
  }

}
