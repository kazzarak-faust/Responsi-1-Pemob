package com.unsoed.responsi1mobileh1d023113

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023113.data.api.NetworkModule
import com.unsoed.responsi1mobileh1d023113.data.repository.TeamRepository
import com.unsoed.responsi1mobileh1d023113.databinding.ActivityCoachBinding
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModel
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModelFactory

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val viewModel: TeamViewModel by viewModels {
        TeamViewModelFactory(TeamRepository(NetworkModule.provideApiService()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchTeam(543)
        viewModel.team.observe(this) { team ->
            binding.tvCoachName.text = team.coach?.name ?: "-"
            binding.tvCoachRole.text = team.coach?.nationality ?: "-"
            Glide.with(this)
                .load("https://cdn-icons-png.flaticon.com/512/3135/3135715.png")
                .into(binding.ivCoach)
        }
    }
}
