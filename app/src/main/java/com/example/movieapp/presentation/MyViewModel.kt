package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMovieUseCase

 class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase


    ):ViewModel() {

        fun getMovies() = liveData {
            val movieList= getMoviesUseCase.execute()
            emit(movieList)
        }

    fun updateMovies() = liveData {
        val movieList= updateMovieUseCase.execute()
        emit(movieList)
    }



}