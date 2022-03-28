package com.hieuminh.lovejourney.utils

import android.content.Context

object StringUtil {
    fun getString(context: Context?, id: Int): String? {
        return context?.resources?.getString(id)
    }
}
