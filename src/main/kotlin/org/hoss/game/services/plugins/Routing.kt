package org.hoss.game.services.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import org.hoss.game.models.Greeting
import org.hoss.game.models.TokensInput
import org.hoss.game.models.TokensResponse
import org.hoss.game.services.checkCommands
import org.hoss.game.services.filterTokens
import org.hoss.game.services.getTokens
import org.hoss.game.services.getVerb

fun Application.configureRouting() {

    routing {
        get("/") {
            val greeting = Greeting("Hello world!")
            call.respond(greeting)
        }
        post("/tokens") {
            val inputStr = call.receive<TokensInput>()
            println("input string : ${inputStr.toString()}")
            val tokens = getTokens(inputStr.inputStr)
            val filtered = filterTokens(tokens)
            val command = checkCommands(tokens)
            val verb = getVerb(tokens)
            val response: TokensResponse = TokensResponse(filtered, filtered.size, command, verb)
            call.respond(HttpStatusCode.OK, response)
        }
    }
}
