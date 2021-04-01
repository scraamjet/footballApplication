package com.example.footballapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface FootballAPI {
    @GET("standings")
    suspend fun getTeamsList():FootballResponse
    @GET("standings")
    suspend fun getTeamById(@Query("id") id: Int): FootballResponse
}