package me.jiayu

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json
import java.time.Instant

@Location("/list/{name}/page/{page}")
data class ListingParams(val name: String, val page: Int)

fun Application.myRoutes() {
    routing {
        install(ContentNegotiation) {
            json()
        }
        install(Locations)
        getTimeRoute()
    }
}

fun Route.getTimeRoute() {
    get("/time") {
        val value = TimeInfo(Instant.now())
        call.respond(value)
    }
    get<ListingParams> { listing ->
        call.respondText("name ${listing.name} page ${listing.page}")
    }
}