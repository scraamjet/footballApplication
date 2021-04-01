package com.example.footballapplication

import com.google.gson.annotations.SerializedName

data class FootballResponse (
        @SerializedName("filters")
        var filters:Filters,
        @SerializedName("competition")
        var competition: Competition,
        @SerializedName("season")
        var season:Season,
        @SerializedName("standings")
        var standings: List<Standings>
        )