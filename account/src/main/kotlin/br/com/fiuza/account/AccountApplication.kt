package br.com.fiuza.account

import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.server.reactive.HttpHandler
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.server.adapter.WebHttpHandlerBuilder
import reactor.netty.DisposableServer
import reactor.netty.http.server.HttpServer

class AccountApplication {

	private val httpHandler: HttpHandler

	private val server: HttpServer

	private var nettyContext: DisposableServer? = null

	constructor(port: Int = 8680) {
		val context = GenericApplicationContext()
		beans().initialize(context)
		context.refresh()
		server = HttpServer.create().host("localhost").port(port)
		httpHandler = WebHttpHandlerBuilder.applicationContext(context)
				.build()
	}

	fun start() {
		nettyContext = server.handle(ReactorHttpHandlerAdapter(httpHandler)).bindNow()
	}

	fun startAndWait() {
		server.handle(ReactorHttpHandlerAdapter(httpHandler)).bindNow().onDispose().block()
	}

	fun stop() {
		nettyContext?.disposeNow()
	}
}

fun main(args: Array<String>) {
	AccountApplication().startAndWait()
}

