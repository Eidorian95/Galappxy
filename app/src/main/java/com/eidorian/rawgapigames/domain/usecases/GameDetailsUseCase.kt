package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.GameDetailsResponse
import com.eidorian.rawgapigames.data.entity.response.toGameDetail
import com.eidorian.rawgapigames.data.repository.GamesRepository
import com.eidorian.rawgapigames.presentation.model.GameDetail
import javax.inject.Inject

class GameDetailsUseCase @Inject constructor(private val repo: GamesRepository) : BaseUSeCase() {

    fun getGameDetails(
        id: Int,
        onSuccess: (games: GameDetail?) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        makeCall({ repo.getGameDetails(id) },
            object : UseCaseCallback<GameDetailsResponse> {
                override fun onSuccess(data: GameDetailsResponse) {
                    onSuccess(data.toGameDetail())
                }

                override fun onError(t: Throwable) {
                    onError(t)
                }
            })
    }
}