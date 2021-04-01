package com.example.footballapplication

import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("id")
    var id:Long,
    @SerializedName("name")
    var name: String
)
