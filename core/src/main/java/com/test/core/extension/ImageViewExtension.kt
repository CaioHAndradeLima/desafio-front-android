package com.test.core.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide


fun ImageView.load(@DrawableRes drawable: Int) {
    Glide
        .with(context)
        .load(drawable)
        .into(this)
}