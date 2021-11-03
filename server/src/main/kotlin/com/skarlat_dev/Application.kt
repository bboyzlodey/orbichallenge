package com.skarlat_dev

import com.skarlat_dev.domain.storage.db.MariaDB
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.skarlat_dev.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureMonitoring()
        configureHTTP()
        MariaDB().connect()
//        configureSecurity()
    }.start(wait = true)
}
