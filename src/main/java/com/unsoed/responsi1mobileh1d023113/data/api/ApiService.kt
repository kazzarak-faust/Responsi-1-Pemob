package com.unsoed.responsi1mobileh1d023113.data.api

import com.unsoed.responsi1mobileh1d023113.data.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: Int): TeamResponse
}
