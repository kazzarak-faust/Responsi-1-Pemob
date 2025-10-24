package com.unsoed.responsi1mobileh1d023113

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023113.data.api.NetworkModule
import com.unsoed.responsi1mobileh1d023113.data.repository.TeamRepository
import com.unsoed.responsi1mobileh1d023113.databinding.ActivityPlayersBinding
import com.unsoed.responsi1mobileh1d023113.ui.players.PlayerDetailFragment
import com.unsoed.responsi1mobileh1d023113.ui.players.PlayersAdapter
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModel
import com.unsoed.responsi1mobileh1d023113.ui.viewmodel.TeamViewModelFactory

class PlayersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayersBinding
    private val viewModel: TeamViewModel by viewModels {
        TeamViewModelFactory(TeamRepository(NetworkModule.provideApiService()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PlayersAdapter(emptyList()) { player ->
            val fragment = PlayerDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("player", player)
                }
            }

            binding.container.visibility = View.VISIBLE

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("detail")
                replace(R.id.container, fragment)
            }
        }

        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
        binding.rvPlayers.adapter = adapter

        viewModel.team.observe(this) { team ->
            team?.let {
                adapter.items = it.squad!!
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.fetchTeam(543)
    }

}
