package br.tur.advanced.rf.ordempagamento.domain.repository

import br.tur.advanced.rf.ordempagamento.domain.modelo.Op
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OpRepository: ReactiveMongoRepository<Op, String> {
}