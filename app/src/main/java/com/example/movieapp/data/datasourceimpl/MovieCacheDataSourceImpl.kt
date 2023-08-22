package com.example.movieapp.data.datasourceimpl

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.model.Movie

class MovieCacheDataSourceImpl:MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()


    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
       movieList.clear()
        movieList=ArrayList(movies)
    }
}