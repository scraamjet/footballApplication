package com.example.footballapplication

import com.google.gson.annotations.SerializedName
import java.util.*

data class Competition(
    @SerializedName("id")
    var id: Long,
    @SerializedName("area")
    var area: Area,
    @SerializedName("name")
    var name: String,
    @SerializedName("plan")
    var plan: String,
    @SerializedName("season")
    var currentSeason: Season,
    @SerializedName("lastUpdated")
    var lastUpdated: Date
)
