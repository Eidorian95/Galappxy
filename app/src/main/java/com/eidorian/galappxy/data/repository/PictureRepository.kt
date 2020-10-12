package com.eidorian.galappxy.data.repository

import com.eidorian.galappxy.data.remote.PictureRemoteDataSource
import javax.inject.Inject

class PictureRepository @Inject constructor(
    private val remoteDataSource: PictureRemoteDataSource
) {

}