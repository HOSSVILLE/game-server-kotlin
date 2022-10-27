package org.hoss.game

import io.ktor.server.application.*
import org.hoss.game.plugins.configureRouting
import org.hoss.game.plugins.configureSerialization

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    configureSerialization()
}
