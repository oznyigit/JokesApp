package com.oznyigit.jokesapp.retrofit

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://official-joke-api.appspot.com/"

        fun getJokesDao() : JokesDao
        {
            return RetrofitClient
                .getClient(BASE_URL)
                .create(JokesDao::class.java)
        }
    }
}