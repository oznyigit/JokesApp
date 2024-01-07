package com.oznyigit.jokesapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class JokeResponse(@SerializedName("type") var type: String,
                        @SerializedName("setup") var setup: String,
                        @SerializedName("punchline") var punchline: String,
                        @SerializedName("id") var id: Int) : Serializable