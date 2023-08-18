package com.example.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.model.Movie


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies (movies:List<Movie>)

    @Query ("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie")
    suspend fun getMovies() :List<Movie>

}