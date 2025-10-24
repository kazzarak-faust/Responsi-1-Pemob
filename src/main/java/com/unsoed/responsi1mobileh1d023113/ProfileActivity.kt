package com.unsoed.responsi1mobileh1d023113

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023113.data.api.NetworkModule
import com.unsoed.responsi1mobileh1d023113.data.repository.TeamRepository
import com.unsoed.responsi1mobileh1d023113.databinding.ActivityProfileBinding
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModel
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModelFactory

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: TeamViewModel by viewModels {
        val api = NetworkModule.provideApiService()
        val repository = TeamRepository(api)
        TeamViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchTeam(543) // ID FC Nantes

        viewModel.team.observe(this) { team ->
            team?.let {
                Glide.with(this)
                    .load(it.crest)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.ivCrest)

                binding.tvName.text = it.name
                binding.tvFounded.text = "Didirikan: ${it.founded ?: '-'}"
                binding.tvVenue.text = "Stadion: ${it.venue ?: '-'}"
            }
        }
    }
}
