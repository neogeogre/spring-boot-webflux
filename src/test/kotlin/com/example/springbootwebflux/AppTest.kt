package com.example.springbootwebflux

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class AppTest {

  @Autowired
  private lateinit var webTestClient: WebTestClient

  companion object {
    @JvmStatic
    fun endpoints() = listOf(
      Arguments.of("/foo", "Foo, Spring webflux !"),
      Arguments.of("/bar", "Bar, Spring webflux !"),
    )
  }

  @ParameterizedTest
  @MethodSource("endpoints")
  fun `test web flux`(endpoint: String, result: String) {
    val pojo = webTestClient
      .get().uri(endpoint)
      .accept(APPLICATION_JSON)
      .exchange() // and use the dedicated DSL to test assertions against the response
      .expectStatus().isOk
      .returnResult(Pojo::class.java).responseBody.blockFirst()!!

    assertThat(pojo.message).isEqualTo(result)
  }

}
