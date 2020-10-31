package com.eidorian.rawgapigames.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class BindAdapter {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }

        @BindingAdapter("visible")
        @JvmStatic
        fun setVisible(view: View, isVisible: Boolean) {
            view.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }
}