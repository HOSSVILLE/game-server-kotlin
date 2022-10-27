package org.hoss.game.models

import kotlinx.serialization.Serializable

@Serializable
data class TokensResponse(val tokens: List<String>, val tokenCount: Int, val command: String = "*", val verb: String = "*",  val noun: String = "*")
