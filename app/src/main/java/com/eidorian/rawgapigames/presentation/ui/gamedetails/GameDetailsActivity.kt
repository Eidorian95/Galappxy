package com.eidorian.rawgapigames.presentation.ui.gamedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.databinding.ActivityGameDetailsBinding
import com.eidorian.rawgapigames.databinding.ActivityMainBinding
import com.eidorian.rawgapigames.presentation.ui.listgames.MainViewModel
import com.eidorian.rawgapigames.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailsBinding

    private val viewModel: GameDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_details)
        binding.lifecycleOwner = this

        setObservers()
    }

    private fun setObservers() {
        viewModel.getDetails().observe(this, Observer {
            when(it.state){
                Status.SUCCESS -> binding.details = it.data
                else-> Log.d("DETAILS_ERROR", it.message.toString())
            }
        })
    }
}