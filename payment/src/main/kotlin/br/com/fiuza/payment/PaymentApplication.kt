package br.com.fiuza.payment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@SpringBootApplication
class PaymentApplication

fun main(args: Array<String>) {
    runApplication<PaymentApplication>(*args) {
        router {
            accept(MediaType.TEXT_PLAIN).nest {
                GET("/") {ServerResponse.ok().render("index")}
            }
        }
    }
    print(HelloWebClient().getResult())
}

