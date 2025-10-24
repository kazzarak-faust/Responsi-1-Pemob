package com.unsoed.responsi1mobileh1d023113.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023113.data.model.Player
import com.unsoed.responsi1mobileh1d023113.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment : Fragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = arguments?.getParcelable<Player>("player")
        player?.let {
            binding.tvPlayerName.text = it.name
            binding.tvPlayerPosition.text = it.position
            binding.tvPlayerNationality.text = it.nationality
            binding.tvPlayerNumber.text = "Nomor: ${it.shirtNumber ?: "-"}"
            Glide.with(this)
                .load(it.imageUrl)
                .into(binding.ivPlayerDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
