package com.eidorian.rawgapigames.presentation.model

import com.eidorian.rawgapigames.data.entity.response.GamesResponse

data class Game(
    val id: Int,
    val name: String,
    val release: String,
    val backgroundImage: String,
    val rating: Double,
    val ratingTop: Int
)