package com.unsoed.responsi1mobileh1d023113.data.repository

import com.unsoed.responsi1mobileh1d023113.data.api.ApiService

class TeamRepository(private val api: ApiService) {
    suspend fun getTeam(id: Int) = api.getTeam(id)
}
