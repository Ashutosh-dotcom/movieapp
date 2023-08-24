package com.example.movieapp.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.db.MovieDao
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides

    fun provideMovieDataBase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,
        TMDBDatabase::class.java,
            "tmdb").build()

    }
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase) :MovieDao{

        return tmdbDatabase.movieDao()

    }
}