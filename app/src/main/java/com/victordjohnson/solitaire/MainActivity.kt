package com.victordjohnson.solitaire

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var counter = 0
        relativeLayout {
            val counterTextView = textView {
                id = View.generateViewId()
                text = "0"
                textSize = 24f
            }
            button {
                onClick {
                    counter++
                    counterTextView.text = counter.toString()
                }
            }.lparams {
                below(counterTextView)
            }
        }

    }
}
