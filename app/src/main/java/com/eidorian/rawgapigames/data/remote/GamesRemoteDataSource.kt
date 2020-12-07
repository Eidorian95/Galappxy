package com.eidorian.rawgapigames.data.remote

import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getGamesList() = apiService.getGamesList()

    fun searchGameByName(name: String) = apiService.searchGameByName(name)

    fun orderGamesBy(ordering: String, search: String) = apiService.orderGamesBy(ordering, search)
}