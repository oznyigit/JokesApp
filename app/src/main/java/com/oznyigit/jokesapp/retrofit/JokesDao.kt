package com.oznyigit.jokesapp.retrofit

import com.oznyigit.jokesapp.data.entity.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokesDao {
    @GET("random_joke")
    fun getJoke() : Call<JokeResponse>
}