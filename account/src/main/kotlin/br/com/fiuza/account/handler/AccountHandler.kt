package br.com.fiuza.account.handler

import br.com.fiuza.account.model.Account
import br.com.fiuza.account.repository.AccountRepository
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono
import java.net.URI

class AccountHandler(val accounts: AccountRepository) {

    fun home(req: ServerRequest) : Mono<ServerResponse> {
        return ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just("{message: hello Spring WebFlux}"), String::class.java)
    }

    fun save(req: ServerRequest) : Mono<ServerResponse> {
        val account = Account(id = "2", content = "Um", title = "Titulo 1")
        val save = accounts.save(account)
        return created(URI.create("/get/"+save)).contentType(MediaType.APPLICATION_JSON).build()
    }
}