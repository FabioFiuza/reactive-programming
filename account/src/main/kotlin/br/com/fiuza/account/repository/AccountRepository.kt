package br.com.fiuza.account.repository

import br.com.fiuza.account.model.Account
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

class AccountRepository(private val template: ReactiveMongoTemplate) {
    fun save(post: Account) = template.save(post)

}