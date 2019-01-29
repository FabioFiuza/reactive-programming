package br.tur.advanced.rf.ordempagamento.routers

import br.tur.advanced.rf.ordempagamento.handler.OpHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Router {

    @Bean
    fun opRouter (handler: OpHandler) = router {
        ("/orderPagamento" and accept(MediaType.APPLICATION_JSON)).nest {
            POST("/criar", handler::criar)
        }
    }
}



