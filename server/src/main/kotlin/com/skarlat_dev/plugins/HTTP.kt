package com.skarlat_dev.plugins

import io.ktor.application.*
import io.ktor.features.*

fun Application.configureHTTP() {
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }

}
