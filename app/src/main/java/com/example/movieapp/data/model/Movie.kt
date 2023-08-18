package com.example.movieapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName ="movie")
data class Movie(
    @SerializedName("id")
    val Movieid  :Int,


    @SerializedName("overview")
    val  overview : String,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("release_date")
    val releaseDate:String,

    @SerializedName("title")
    val title : String

)
