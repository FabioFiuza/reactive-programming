package br.tur.advanced.rf.ordempagamento.handler

import br.tur.advanced.rf.ordempagamento.domain.modelo.Reserva
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class OpHandler {
    fun criar (request: ServerRequest): Mono<ServerResponse> = ServerResponse.ok().body(request.bodyToMono<Reserva>(), Reserva::class.java)
}