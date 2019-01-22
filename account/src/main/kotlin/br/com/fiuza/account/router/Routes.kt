package br.com.fiuza.account.router

import br.com.fiuza.account.handler.AccountHandler
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class Routes (private val handler: AccountHandler) {

    fun router () = router {
        accept(MediaType.APPLICATION_JSON).nest{
            GET("/", handler::home)
            GET("/save", handler::save)
        }
    }

}