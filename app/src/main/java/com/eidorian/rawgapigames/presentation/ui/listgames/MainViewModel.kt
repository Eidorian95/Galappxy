package com.eidorian.rawgapigames.presentation.ui.listgames

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eidorian.rawgapigames.domain.usecases.GetGamesUseCase
import com.eidorian.rawgapigames.presentation.ViewState
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.utils.Status.ERROR
import com.eidorian.rawgapigames.utils.Status.SUCCESS

class MainViewModel @ViewModelInject constructor(
    private val gamesUseCase: GetGamesUseCase
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    private val _viewState = MutableLiveData<ViewState<List<Game>>>()

    init {
        getGames()
    }

    private fun getGames() {
        _loading.value = true
        gamesUseCase.getGamesList({
            _viewState.value = ViewState(SUCCESS, it)
            _loading.value = false
        }, {
            _viewState.value = ViewState(ERROR, null, it.message)
        })
    }

    fun searchGame(name: String) {
        _loading.value = true
        gamesUseCase.searchGameByName(name,
            {
                _viewState.value = ViewState(SUCCESS, it)
                _loading.value = false
            },
            {
                _viewState.value = ViewState(ERROR, null, it.message)
            })
    }

    fun getGamesList(): LiveData<ViewState<List<Game>>> = _viewState
    fun isLoading(): LiveData<Boolean> = _loading
}