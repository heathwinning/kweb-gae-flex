package com.example

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.Compression
import io.ktor.features.DefaultHeaders
import io.ktor.html.respondHtml
import io.ktor.http.cio.websocket.pingPeriod
import io.ktor.http.cio.websocket.timeout
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
import io.ktor.websocket.WebSockets
import io.kweb.Kweb
import io.kweb.dom.element.creation.tags.button
import io.kweb.dom.element.creation.tags.h1
import io.kweb.dom.element.creation.tags.input
import io.kweb.dom.element.creation.tags.span
import io.kweb.dom.element.new
import io.kweb.state.KVar
import io.kweb.state.path
import io.kweb.state.simpleUrlParser
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title
import java.time.Duration

fun Application.main() {
    install(DefaultHeaders)
    install(Compression)
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(10)
        timeout = Duration.ofSeconds(30)
    }

    install(Kweb) {
        buildPage = {
            doc.body.new {
                h1().text("Hello world, this is Kweb")
            }
        }
    }
}



