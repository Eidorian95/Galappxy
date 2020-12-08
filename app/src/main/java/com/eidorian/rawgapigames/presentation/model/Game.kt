package com.eidorian.rawgapigames.presentation.model

open class Game(
    open val id: Int,
    open val name: String?,
    open val backgroundImage: String?,
    open val rating: Double?,
    open val platforms: List<Platform>?
) {
    data class Platform(
        val id: Int,
        val slug: String
    )
}

data class GameDetail(
    override val id: Int,
    override val name: String?,
    override val backgroundImage: String?,
    override val rating: Double?,
    override val platforms: List<Platform>?,
    val description:String?,
    val released:String?
) : Game(id, name, backgroundImage, rating, platforms)