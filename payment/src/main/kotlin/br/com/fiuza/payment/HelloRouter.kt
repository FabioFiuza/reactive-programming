package br.com.fiuza.payment

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.RouterFunction



@Configuration
class HelloRouter {

    @Bean
    fun routes(helloWorld: HelloHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/hello"), HandlerFunction { helloWorld.hello(it) })
    }


}