package com.eidorian.rawgapigames.data.repository

import com.eidorian.rawgapigames.data.remote.GamesRemoteDataSource
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: GamesRemoteDataSource
) {
    //TODO: Add logic to search in local DB before remote if is necessary
    fun getGamesList() = remoteDataSource.getGamesList()

    fun searchGameByName(name: String) = remoteDataSource.searchGameByName(name)

    fun orderGamesBy(ordering: String, search: String) =
        remoteDataSource.orderGamesBy(ordering, search)

    fun getGameDetails(id: Int) = remoteDataSource.getGameDetails(id)

}