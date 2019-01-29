package br.tur.advanced.rf.ordempagamento.domain.modelo

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

@Document(collection = "op")
data class Op (@Id val id: String?, val dadosReserva: Reserva)