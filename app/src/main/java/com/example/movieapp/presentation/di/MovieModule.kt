package com.example.movieapp.presentation.di

import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMovieUseCase
import com.example.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ):ViewModelFactory{

        return ViewModelFactory(
            getMoviesUseCase,
            updateMovieUseCase
        )

    }
}