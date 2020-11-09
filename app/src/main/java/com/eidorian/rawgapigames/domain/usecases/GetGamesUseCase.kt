package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.utils.Status.SUCCESS
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: GamesRepository) {

    suspend fun getGamesList(
        onSuccess: (games: List<Game>) -> Unit,
        onError: (message: String) -> Unit
    ) {
        val response = repository.getGamesList()
        when (response.status) {
            SUCCESS -> {
                val data = response.data as GamesResponse
                val games: List<Game> = data.results.map { result ->
                    Game(
                        result.id,
                        result.name,
                        result.released,
                        result.backgroundImage,
                        result.rating,
                        result.ratingTop
                    )
                }
                onSuccess(games)
            }
            else -> response.message?.let { onError(it) }
        }
    }
}