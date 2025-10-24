package com.unsoed.responsi1mobileh1d023113.ui.players

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023113.data.model.Player
import com.unsoed.responsi1mobileh1d023113.databinding.ItemPlayerBinding

class PlayersAdapter(
    var items: List<Player>,
    private val onClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = items[position]
        val binding = holder.binding

        binding.tvPlayerName.text = player.name
        binding.tvPlayerPosition.text = player.position
        binding.tvPlayerNationality.text = player.nationality
        Glide.with(binding.root)
            .load(player.imageUrl)
            .into(binding.ivPlayer)

        when (player.position) {
            "Goalkeeper" -> binding.cardViewPlayer.setCardBackgroundColor(Color.YELLOW)
            "Defender" -> binding.cardViewPlayer.setCardBackgroundColor(Color.BLUE)
            "Midfield" -> binding.cardViewPlayer.setCardBackgroundColor(Color.GREEN)
            "Forward" -> binding.cardViewPlayer.setCardBackgroundColor(Color.RED)
            else -> binding.cardViewPlayer.setCardBackgroundColor(Color.LTGRAY)
        }

        holder.itemView.setOnClickListener {
            onClick(player)
        }
    }

    override fun getItemCount(): Int = items.size
}
