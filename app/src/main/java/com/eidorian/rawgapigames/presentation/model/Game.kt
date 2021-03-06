package com.eidorian.rawgapigames.presentation.model

data class Game(
    val id: Int,
    val name: String?,
    val release: String?,
    val backgroundImage: String?,
    val rating: Double?,
    val ratingTop: Int?,
    val platforms: List<Platform>?
) {
    data class Platform(val id: Int,
                        val slug: String)
}