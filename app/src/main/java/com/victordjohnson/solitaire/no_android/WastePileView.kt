package com.victordjohnson.solitaire.no_android

import android.content.Context
import android.widget.ImageView
import com.victordjohnson.solitaire.Card
import com.victordjohnson.solitaire.GameModel
import com.victordjohnson.solitaire.GamePresenter
import com.victordjohnson.solitaire.emptyPileDrawable
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class WastePileView(context: Context): ImageView(context) {
    init{
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }
    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }

    private fun getResIdForCard(card: Card): Int {

    }
}