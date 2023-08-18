package com.example.movieapp.data.api

import com.example.movieapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie")

    suspend fun getMovies(
        @Query(
            "api_key"
        )apiKey:String
    ): Response<MovieList>
}