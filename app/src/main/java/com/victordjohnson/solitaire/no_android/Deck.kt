package com.victordjohnson.solitaire

import java.util.*

class Deck {
    val cards = Array(52, { Card(it % 13, getSuit(it)) })
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    private fun getSuit(i: Int) = when(i / 13) {
            0 -> fire
            1 -> electric
            2 -> water
            else -> grass
        }

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp = false }
        Collections.shuffle(cardsInDeck)
    }
}