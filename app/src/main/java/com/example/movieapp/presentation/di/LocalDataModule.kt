package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasourceimpl.MovieLocalDataSourceImpl
import com.example.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {


    @Singleton
    @Provides

    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {

        return MovieLocalDataSourceImpl(movieDao)

    }
}