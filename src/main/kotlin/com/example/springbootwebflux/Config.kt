package com.example.springbootwebflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration(proxyBeanMethods = false)
class Config {

  @Bean
  fun route(controller: Controller): RouterFunction<ServerResponse> {
    return RouterFunctions
      .route(
        GET("/foo").and(accept(APPLICATION_JSON))
      ) { request -> controller.foo(request) }
      .andRoute(
        GET("/bar").and(accept(APPLICATION_JSON))
      ) { request -> controller.bar(request) }
  }

}
