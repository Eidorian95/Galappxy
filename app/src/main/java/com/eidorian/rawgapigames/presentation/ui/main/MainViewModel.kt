package com.eidorian.rawgapigames.presentation.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eidorian.rawgapigames.presentation.model.Picture
import com.eidorian.rawgapigames.data.repository.GamesRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    private val _picture = MutableLiveData<Picture>()

    init {
        getTodayPicture()
    }

    private fun getTodayPicture() {
        _loading.value = true
        viewModelScope.launch {
            _picture.value = gamesRepository.getTodayPicture().data
            _loading.value = false
        }
    }

    fun getPicture(): LiveData<Picture> = _picture
    fun isLoading(): LiveData<Boolean> = _loading
}