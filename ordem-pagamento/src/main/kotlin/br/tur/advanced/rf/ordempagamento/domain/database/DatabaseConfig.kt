package br.tur.advanced.rf.ordempagamento.domain.database

import com.mongodb.reactivestreams.client.MongoClients.create
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
class DatabaseConfig {

    @Bean
    fun reactiveMongoClient() = create("mongodb://localhost:27017")


    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), "op")
    }

}