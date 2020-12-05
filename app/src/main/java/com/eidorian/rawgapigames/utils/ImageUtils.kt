package com.eidorian.rawgapigames.utils

import com.eidorian.rawgapigames.R

class ImageUtils {
    companion object {
        fun getImageDrawable(image: String?): Int = when (image) {
            "playstation" -> R.drawable.ic_ps_logo
            "xbox" -> R.drawable.ic_xbox_logo
            "pc" -> R.drawable.ic_pc_logo
            "mac" -> R.drawable.ic_mac_logo
            "android" -> R.drawable.ic_android_logo
            "ios" -> R.drawable.ic_ios_store_logo
            "linux" -> R.drawable.ic_linux_logo
            "nintendo" -> R.drawable.ic_nintendo_logo
            else -> R.drawable.ic_launcher_foreground
        }
    }
}