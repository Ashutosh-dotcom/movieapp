package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.Movie

interface MovieCacheDataSource {

    suspend fun getMovieFromCache() : List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}