package com.hieuminh.lovejourney.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.lovejourney.models.base.BaseModel

class Event: BaseModel() {
    @SerializedName("id")
    @Expose
    var id: Long? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("data_list")
    @Expose
    var dataList: List<Data>? = null
}