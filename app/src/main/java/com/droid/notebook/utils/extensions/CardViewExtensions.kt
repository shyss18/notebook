package com.droid.notebook.utils.extensions

import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.droid.notebook.R
import kotlin.random.Random

@BindingAdapter(value = ["setRandomColor"])
fun CardView.bindRandomColor(isBind: Boolean) {
    this.run {
        if(isBind) {
            val androidColors = resources.getIntArray(R.array.androidColors)
            val randomColor = androidColors[Random.nextInt(androidColors.count())]
            this.setCardBackgroundColor(randomColor)
        }
    }
}