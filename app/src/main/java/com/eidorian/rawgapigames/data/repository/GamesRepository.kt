package com.eidorian.rawgapigames.data.repository

import com.eidorian.rawgapigames.data.remote.GamesRemoteDataSource
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: GamesRemoteDataSource
) {
    suspend fun getTodayPicture() = remoteDataSource.getTodayPicture()

}