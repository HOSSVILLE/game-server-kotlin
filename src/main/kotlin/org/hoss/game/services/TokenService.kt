package org.hoss.game.services

private val removeitems:Set<String> = HashSet<String>(listOf("a","an","the","is","it"))

private val verbs:Set<String> = setOf("take","look","open","drink","read")
private val nouns:Set<String> = setOf("chest","book","rock","stone","wood","ring")
private val commands:Set<String> = setOf("inventory","inv","exit","save","c","character")

fun getTokens(inputStr: String): List<String> {
    return inputStr.split(" ")
}

fun filterTokens(tokens: List<String>): List<String> {
    val filtered = mutableListOf<String>()
    for (token in tokens) {
        if (!removeitems.contains(token)) {
            filtered.add(token)
        } else {
            println("Not adding $token")
        }
    }
    return filtered
}

fun checkCommands(tokens:List<String>): String {
    var result:String = "*"

    for(token in tokens) {
        if (commands.contains(token)) {
            println("found command $token")
            result = token
            break;
        }
    }
    return result;
}

fun getVerb(tokens: List<String>):String {
    var result:String = "*";

    for (token in tokens) {
        if (verbs.contains(token)) {
            println("found verb $token")
            result = token;
            break;
        }
    }
    return result
}
