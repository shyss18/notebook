package com.droid.notebook.utils.extensions

import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import com.droid.notebook.R

@BindingAdapter(value = ["setResourceImage"])
fun ImageButton.bindSrcImage(isEditMode: Boolean) {
    this.run {
        if (isEditMode) setImageResource(R.drawable.background_edit_button) else setImageResource(R.drawable.background_add_button)
    }
}