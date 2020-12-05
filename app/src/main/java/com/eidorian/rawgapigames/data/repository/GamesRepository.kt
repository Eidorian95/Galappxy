package com.eidorian.rawgapigames.data.repository

import com.eidorian.rawgapigames.data.remote.GamesRemoteDataSource
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: GamesRemoteDataSource
) {
    //TODO: Add logic to search in local DB before remote
    fun getGamesListRxJava() = remoteDataSource.getGamesListRxJava()
}