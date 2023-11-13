package com.example.mymuscleapp.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Test","Hello")
        mainViewModel.getExercises()
    }
}


