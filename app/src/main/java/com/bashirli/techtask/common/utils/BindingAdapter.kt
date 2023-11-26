package com.bashirli.techtask.common.utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.progressindicator.CircularProgressIndicator


object BindingAdapter {

    @BindingAdapter("load_resource")
    @JvmStatic
    fun setImageResource(imageView: ImageView, resource: Int?) {
        resource?.let {
            imageView.setImageResource(resource)
        }
    }

    @BindingAdapter("image_color")
    @JvmStatic
    fun setImageColor(imageView: ImageView, color: String?) {
        color?.let {

            imageView.imageTintList = ColorStateList.valueOf(Color.parseColor(color))
        }
    }

    @BindingAdapter("progress_bar_color")
    @JvmStatic
    fun setProgressBarColor(circularProgressIndicator: CircularProgressIndicator, color: String?) {
        color?.let {
            circularProgressIndicator.setIndicatorColor(Color.parseColor(color))
        }
    }

}