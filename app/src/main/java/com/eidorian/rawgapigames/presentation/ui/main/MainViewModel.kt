package com.eidorian.rawgapigames.presentation.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eidorian.rawgapigames.presentation.ViewState
import com.eidorian.rawgapigames.domain.usecases.GetGamesUseCase
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.utils.Status
import com.eidorian.rawgapigames.utils.Status.*
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val gamesUseCase: GetGamesUseCase
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    private val _viewState = MutableLiveData<ViewState<List<Game>>>()

    init {
        getTodayPicture()
    }

    private fun getTodayPicture() {
        _loading.value = true
        viewModelScope.launch {
            gamesUseCase.getGamesList(
                {
                    _viewState.value = ViewState(SUCCESS, it)
                },
                {
                    _viewState.value = ViewState(ERROR, null, it)
                })
            _loading.value = false
        }
    }

    fun getPicture(): LiveData<ViewState<List<Game>>> = _viewState
    fun isLoading(): LiveData<Boolean> = _loading
}