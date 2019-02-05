package com.victordjohnson.solitaire

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.z1
val emptyPileDrawable = R.drawable.z2

class MainActivity : AppCompatActivity(), GameView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        var cardHeight = cardWidth * 190 / 140

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)
            backgroundColor = getColor(R.color.background)

            linearLayout {
                deckView().lparams(cardWidth, cardHeight)
                imageView (imageResource = emptyPileDrawable).lparams (cardWidth, cardHeight)
                view().lparams(cardWidth, 0)

                for (i in 0..3) {
                    imageView (imageResource = emptyPileDrawable).lparams(cardWidth, cardHeight)
                }
            }
            linearLayout {

            }
        }

    }
    override fun update(gameModel: GameModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
