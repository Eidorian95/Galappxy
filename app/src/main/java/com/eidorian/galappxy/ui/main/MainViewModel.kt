package com.eidorian.galappxy.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.eidorian.galappxy.data.repository.PictureRepository

class MainViewModel @ViewModelInject constructor(
    private val pictureRepository: PictureRepository
) : ViewModel() {


}