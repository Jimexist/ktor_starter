package me.jiayu

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.http.toHttpDateString
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json
import io.ktor.server.cio.EngineMain
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.concurrent.ThreadLocalRandom

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Serializable
data class TimeInfo(val time: String, val rand: Int)

fun Application.module(testing: Boolean = false) {
    routing {
        install(ContentNegotiation) {
            json()
        }
        get("/") {
            call.respondText("Hello, world!")
        }
        get("/time") {
            call.respond(TimeInfo(ZonedDateTime.now().toHttpDateString(), rand = ThreadLocalRandom.current().nextInt()))
        }
    }
}
