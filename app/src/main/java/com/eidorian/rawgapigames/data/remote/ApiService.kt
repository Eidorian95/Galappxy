package com.eidorian.rawgapigames.data.remote

import com.eidorian.rawgapigames.presentation.model.Picture
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("planetary/apod")
    suspend fun getTodayPicture() : Response<Picture>
}