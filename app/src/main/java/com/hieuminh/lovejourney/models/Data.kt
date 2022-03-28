package com.hieuminh.lovejourney.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.lovejourney.models.base.BaseModel

class Data : BaseModel() {
    @SerializedName("id")
    @Expose
    var id: Long? = null

    @SerializedName("type")
    @Expose
    var type: Int? = null

    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("created_by")
    @Expose
    var createdBy: Long? = null

    @SerializedName("created_date")
    @Expose
    var createdDate: String? = null

    fun getType(): Int {
        return 0
    }
}