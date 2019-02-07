package com.victordjohnson.solitaire

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback
val emptyPileDrawable = R.drawable.cardbackfade
fun View.getResIdForCard(card: Card): Int {
    val resourceName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

val Context.cardWidth: Int
    get() = (displayMetrics.widthPixels - dip(20)) / 7
val Context.cardHeight: Int
    get() = cardWidth * 190 / 140

class MainActivity : AppCompatActivity(), GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    val foundationPileView: Array<FoundationPileView?> = arrayOfNulls(4)
    val tableauPileViews: Array<TableauPileView?> = arrayOfNulls(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.setBackgroundColor(getColor(R.color.primary_material_dark))

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(20)

            linearLayout {
                deckView = deckView().lparams{ width = cardWidth; height = matchParent; horizontalMargin = dip(2) }
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)
                view().lparams(cardWidth, 0)
                for (i in 0..3) {
                    foundationPileView[i] = foundationPileView(i).lparams{ width = cardWidth; height = matchParent; horizontalMargin = dip(1) }
                }
            }
            linearLayout {
                for (i in 0..6) {
                    tableauPileViews[i] = tableauPileView(i).lparams{ width = cardWidth; height = matchParent; horizontalMargin = dip(1) }
                }
            }.lparams(height = matchParent) {
                topMargin = cardHeight / 2
            }
        }
    }

    override fun update() {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileView.forEach {
            it!!.update()
        }
        tableauPileViews.forEach {
            it!!.update()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Reset")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        GameModel.resetGame()
        update()
        return true
    }
}