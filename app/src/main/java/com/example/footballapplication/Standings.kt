package com.example.footballapplication

import com.google.gson.annotations.SerializedName

data class Standings(
    @SerializedName("stage")
    var stage: String,
    @SerializedName("table")
    var tableList: List<Table> )
