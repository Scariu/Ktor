package com.nahuelbutaeste.plugins

import com.nahuelbutaeste.routes.allFauna
import com.nahuelbutaeste.routes.allFlora
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {
        allFauna()

        staticFiles("", File("http://localhost:8100/faunaimg/"))
        staticResources("", "static")
    }
    routing {
        allFlora()

        staticFiles("", File("http://localhost:8100/floraimg/"))
        staticResources("", "static")
    }
}




