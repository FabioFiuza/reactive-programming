package br.com.fiuza.account

import br.com.fiuza.account.handler.AccountHandler
import br.com.fiuza.account.repository.AccountRepository
import br.com.fiuza.account.router.Routes
import com.mongodb.ConnectionString
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.context.support.beans
import org.springframework.core.io.ClassPathResource
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.repository.support.ReactiveMongoRepositoryFactory
import org.springframework.web.reactive.function.server.HandlerStrategies
import org.springframework.web.reactive.function.server.RouterFunctions

fun beans() = beans {
    bean {
        PropertySourcesPlaceholderConfigurer().apply {
            val resources = arrayOf(ClassPathResource("application.properties"))
            setLocations(* resources)
            setIgnoreUnresolvablePlaceholders(true)
        }
    }

    bean {
        AccountHandler(ref())
    }

    bean {
        Routes(ref())
    }

    bean {
        AccountRepository(ref())
    }

    bean { ReactiveMongoRepositoryFactory(ref()) }

    bean {
        ReactiveMongoTemplate(
                SimpleReactiveMongoDatabaseFactory(
                        //ConnectionString(env["mongo.uri"])
                        ConnectionString("mongodb://localhost:27017/account")
                )
        )
    }

    bean("webHandler") {
        RouterFunctions.toWebHandler(
                ref<Routes>().router(),
                HandlerStrategies.builder()
                        .build()
        )
    }

    bean("messageSource") {
        ReloadableResourceBundleMessageSource().apply {
            setBasename("messages")
            setDefaultEncoding("UTF-8")
        }
    }

}