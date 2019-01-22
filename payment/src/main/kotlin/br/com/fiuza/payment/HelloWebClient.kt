package br.com.fiuza.payment

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class HelloWebClient {

    private val client = WebClient.create("http://localhost:8680")

    private val result = client.get()
            .exchange()

    fun getResult(): String {
        return ">> result = " + result.flatMap { res -> res.bodyToMono(String::class.java) }.block()
    }
}