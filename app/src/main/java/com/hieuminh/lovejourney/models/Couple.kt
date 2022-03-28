package com.hieuminh.lovejourney.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.lovejourney.models.base.BaseModel

class Couple : BaseModel() {
    @SerializedName("id")
    @Expose
    var id: Long? = null

    @SerializedName("female_name")
    @Expose
    var femaleName: String? = null

    @SerializedName("male_name")
    @Expose
    var maleName: String? = null

    @SerializedName("male_id")
    @Expose
    var maleId: Long? = null

    @SerializedName("female_id")
    @Expose
    var femaleId: Long? = null

    @SerializedName("confession_day")
    @Expose
    var confessionDay: String? = null

    @SerializedName("events")
    @Expose
    var events: List<Event>? = null

}