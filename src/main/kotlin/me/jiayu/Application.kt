package me.jiayu

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.toHttpDateString
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.cio.EngineMain
import kotlinx.serialization.Serializable
import java.time.Instant

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Serializable
data class TimeInfo(val time: String, val intValue: Long) {
    constructor(instant: Instant) :this(instant.toHttpDateString(), instant.toEpochMilli())

}

fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("Hello, world!")
        }
    }
    myRoutes()
}


