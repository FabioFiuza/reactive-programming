package br.tur.advanced.rf.ordempagamento.handler

import br.tur.advanced.rf.ordempagamento.domain.modelo.Op
import br.tur.advanced.rf.ordempagamento.domain.repository.OpRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import org.springframework.web.reactive.function.server.json
import java.net.URI

@Component
class OpHandler(private val repository: OpRepository) {
    fun created (request: ServerRequest) = request.bodyToMono<Op>().flatMap {
        repository.save(it).flatMap {
            created(URI("http://localhost:8081/orderPagamento/${it.id}")).build()
        }.onErrorResume {
            badRequest().build()
        }
    }

    fun findAll (request: ServerRequest) = ok().json().bodyToServerSentEvents(repository.findAll())
}