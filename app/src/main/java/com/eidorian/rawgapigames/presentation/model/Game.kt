package com.eidorian.rawgapigames.presentation.model

data class Game(
    private val id: Int,
    private val name: String,
    private val release: String,
    private val backgroundImage: String,
    private val rating: Double,
    private val ratingTop: Int
)