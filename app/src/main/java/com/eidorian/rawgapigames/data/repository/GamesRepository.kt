package com.eidorian.rawgapigames.data.repository

import com.eidorian.rawgapigames.data.remote.GamesRemoteDataSource
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: GamesRemoteDataSource
) {
    //TODO: Agregar logica para buscar de manera local antes de remota
    suspend fun getGamesList() = remoteDataSource.getGamesList()

}