package com.example.footballapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

    object ApiFactory {
        private const val API_ENDPOINT = "https://api.football-data.org/v2/competitions/PL/"


        private val client by lazy {
            OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .addInterceptor(LoggingInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        private val retrofit by lazy {
            Retrofit.Builder()
                .client(client)
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private val footballAPI: FootballAPI by lazy {
            retrofit.create(FootballAPI::class.java)
        }
        suspend fun getTeamsList():FootballResponse {
            return footballAPI.getTeamsList()
        }
        suspend fun getTeamById(id:Int):FootballResponse {
            return footballAPI.getTeamById(id)
        }

    }