package com.unsoed.responsi1mobileh1d023113.data.model

data class TeamResponse(
    val id: Int,
    val name: String,
    val crest: String?,
    val founded: Int?,
    val venue: String?,
    val coach: Coach?,
    val squad: List<Player>?
)

data class Coach(
    val name: String?,
    val nationality: String?
)

