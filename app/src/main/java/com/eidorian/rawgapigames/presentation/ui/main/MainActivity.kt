package com.eidorian.rawgapigames.presentation.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eidorian.rawgapigames.R
import com.eidorian.rawgapigames.databinding.ActivityMainBinding
import com.eidorian.rawgapigames.presentation.ViewState
import com.eidorian.rawgapigames.presentation.model.Game
import com.eidorian.rawgapigames.utils.Status
import com.eidorian.rawgapigames.utils.Status.ERROR
import com.eidorian.rawgapigames.utils.Status.SUCCESS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getGamesList().observe(this, Observer { viewState ->
            when(viewState.state){
                SUCCESS ->  binding.tvGames.text = viewState.data.toString()
                else -> binding.tvGames.text = viewState.message
            }
        })
    }
}