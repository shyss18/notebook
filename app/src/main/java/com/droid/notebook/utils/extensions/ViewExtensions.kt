package com.droid.notebook.utils.extensions

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["bindVisibility"])
fun View.bindVisibility(isVisible: Boolean) {
    this.run {
        this.isVisible = isVisible
    }
}