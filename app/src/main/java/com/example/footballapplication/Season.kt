package com.example.footballapplication

import com.google.gson.annotations.SerializedName
import java.util.*

data class Season(
    @SerializedName("id")
    var id: Long,
    @SerializedName("startDate")
    var startDate: Date,
    @SerializedName("endDate")
    var endDate: Date,
)
