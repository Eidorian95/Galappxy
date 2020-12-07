package com.eidorian.rawgapigames.domain.usecases

import com.eidorian.rawgapigames.data.entity.response.GameDetailsResponse
import com.eidorian.rawgapigames.data.repository.GamesRepository
import javax.inject.Inject

class GameDetailsUseCase @Inject constructor(private val repo:GamesRepository):BaseUSeCase(){

    fun getGameDetails(id:Int){
        makeCall({repo.getGameDetails(id)}, object:UseCaseCallback<GameDetailsResponse>{
            override fun onSuccess(data: GameDetailsResponse) {

            }

            override fun onError(t: Throwable) {

            }
        })
    }
}