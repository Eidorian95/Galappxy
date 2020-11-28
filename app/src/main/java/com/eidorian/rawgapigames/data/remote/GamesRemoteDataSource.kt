package com.eidorian.rawgapigames.data.remote

import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {

    suspend fun getGamesList() = getResult { apiService.getGamesList() }

    fun getGamesListRxJava() = apiService.getGamesListRxJava()
}