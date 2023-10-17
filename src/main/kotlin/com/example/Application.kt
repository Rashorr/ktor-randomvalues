package com.example

import com.example.modules.appModule
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
   install(Koin){
       modules(appModule)
   }
    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureTemplating()
    configureRouting()
}
