package com.example.footballapplication

import android.net.Uri


data class TeamDTO(
    var id:Int,
    var position:Int,
    var name:String,
    var points:Int,
    var imgUrl:String
)