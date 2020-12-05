package com.eidorian.rawgapigames.data.remote

import javax.inject.Inject

class GamesRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {

    fun getGamesListRxJava() = apiService.getGamesListRxJava()
}