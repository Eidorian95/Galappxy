package com.eidorian.rawgapigames.presentation

import com.eidorian.rawgapigames.utils.Status

data class ViewState<T>(var state: Status, var data: T?, var message: String? = null)
