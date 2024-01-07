package com.oznyigit.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oznyigit.jokesapp.data.entity.JokeResponse
import com.oznyigit.jokesapp.databinding.ActivityMainBinding
import com.oznyigit.jokesapp.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val jokeService = ApiUtils.getJokesDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSetup.text = ""
        binding.textViewPunchline.text = ""
        binding.toolbarMainActivity.title = "Ready To Laugh With JokesApp?"

        fetchJoke()

        binding.buttonNextJoke.setOnClickListener {
            fetchJoke()
        }

        binding.buttonQuit.setOnClickListener { finish() }

    }

    private fun fetchJoke() {
        jokeService.getJoke().enqueue(object : Callback<JokeResponse> {
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                if (response.isSuccessful) {
                    val joke = response.body()
                    if (joke != null) {
                        binding.textViewSetup.text = joke.setup
                        binding.textViewPunchline.text = joke.punchline
                    }
                }
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}