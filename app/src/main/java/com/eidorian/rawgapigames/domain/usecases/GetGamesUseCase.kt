package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.GamesResponse
import com.eidorian.rawgapigames.data.entity.response.toGame
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.presentation.model.Game
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: GamesRepository) : BaseUSeCase() {

    fun getGamesList(
        onSuccess: ((games: List<Game>?) -> Unit),
        onError: ((t: Throwable) -> Unit)
    ) {
        makeCall({ repository.getGamesList() },
            object : UseCaseCallback<GamesResponse> {
                override fun onSuccess(data: GamesResponse) {
                    onSuccess(data.toGame())
                }

                override fun onError(t: Throwable) {
                    onError(t)
                }
            })
    }


    fun searchGameByName(
        name: String,
        onSuccess: (games: List<Game>?) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        makeCall(
            { repository.searchGameByName(name) },
            object : UseCaseCallback<GamesResponse> {
                override fun onSuccess(data: GamesResponse) {
                    onSuccess(data.toGame())
                }

                override fun onError(t: Throwable) {
                    onError(t)
                }
            })
    }

    fun orderGamesBy(
        ordering: String,
        search: String,
        onSuccess: (games: List<Game>?) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        makeCall({ repository.orderGamesBy(ordering, search) },
            object : UseCaseCallback<GamesResponse> {
                override fun onSuccess(data: GamesResponse) {
                    onSuccess(data.toGame())
                }

                override fun onError(t: Throwable) {
                    onError(t)
                }

            })
    }
}