package com.unsoed.responsi1mobileh1d023113

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023113.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.btnCoach.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.btnPlayers.setOnClickListener {
            startActivity(Intent(this, PlayersActivity::class.java))
        }
    }
}
