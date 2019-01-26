package com.victordjohnson.solitaire

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        var cardHeight = cardWidth * 190 / 140

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)
            backgroundColor = getColor(R.color.background)

            linearLayout {
                imageView (imageResource = R.drawable.z1).lparams (cardWidth, cardHeight)
                imageView (imageResource = R.drawable.z2).lparams (cardWidth, cardHeight)
                view().lparams(cardWidth, 0)

                imageView (imageResource = R.drawable.fk).lparams (cardWidth, cardHeight)
                imageView (imageResource = R.drawable.g1).lparams (cardWidth, cardHeight)
                imageView (imageResource = R.drawable.f2).lparams (cardWidth, cardHeight)
                imageView (imageResource = R.drawable.eq).lparams (cardWidth, cardHeight)
            }
            linearLayout {

            }
        }

    }
}
