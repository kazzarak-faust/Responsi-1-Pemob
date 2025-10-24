package com.unsoed.responsi1mobileh1d023113.ui.viewmodel

import androidx.lifecycle.*
import com.unsoed.responsi1mobileh1d023113.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d023113.data.repository.TeamRepository
import kotlinx.coroutines.launch

class TeamViewModel(private val repository: TeamRepository) : ViewModel() {
    private val _team = MutableLiveData<TeamResponse>()
    val team: LiveData<TeamResponse> = _team

    fun fetchTeam(teamId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getTeam(teamId)
                _team.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

// 👉 Factory tetap di file yang sama untuk kesederhanaan
class TeamViewModelFactory(private val repo: TeamRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            return TeamViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
