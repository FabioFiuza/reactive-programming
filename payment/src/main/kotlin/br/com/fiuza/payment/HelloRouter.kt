package br.com.fiuza.payment

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class HelloRouter {

    @Bean
    fun routes(helloWorld: HelloHandler)= router {
        ("hello" and accept(MediaType.TEXT_HTML)).nest {
            GET("/hello", helloWorld::hello)
        }
    }
}