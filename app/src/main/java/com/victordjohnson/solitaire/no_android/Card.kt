package com.victordjohnson.solitaire

val fire = "Fire"
val electric = "Electric"
val water = "Water"
val grass = "Grass"
val redSuits = arrayOf(fire, electric)
val blackSuits = arrayOf(water, grass)
val cardsMap = mapOf(0 to "A", 1 to "2", 2 to "3" , 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9", 9 to "10", 10 to "J", 11 to "Q", 12 to "K")

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false) {
    override fun toString(): String =
            if (faceUp) "${cardsMap[value]}".padEnd(2) + "${getSuitChar(suit)}" else "xxx"

    private fun getSuitChar(suit: String): String = when (suit) {
        fire -> "\uD83D\uDD25"
        electric -> "⚡"
        water -> "\uD83D\uDCA7"
        grass -> "\uD83C\uDF32"
        else -> "incorrect suit"
    }
}