package com.hieuminh.lovejourney.models.base

import com.hieuminh.lovejourney.utils.JsonUtil
import java.io.Serializable

abstract class BaseModel : Serializable {
    fun toJson(): String {
        return JsonUtil.toJson(this)
    }

    inline fun <reified T> clone(): T? {
        return JsonUtil.fromJson(this.toJson())
    }
}