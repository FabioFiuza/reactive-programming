package br.tur.advanced.rf.ordempagamento.domain.modelo

data class Reserva (
        val id: Long,
        val agenciaId: Long,
        val grupoId: Long,
        val filial: String,
        val loc: String
    )