package com.example.mymuscleapp.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymuscleapp.data.model.AllExercise
import com.example.mymuscleapp.data.repository.ExerciseRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val exerciseRepositoryImpl: ExerciseRepositoryImpl) : ViewModel() {

    // MutableStateFlow to hold the list of exercises
    private val _items: MutableStateFlow<List<AllExercise>> = MutableStateFlow(emptyList())

    // StateFlow to observe the list of exercises
    val items: StateFlow<List<AllExercise>> = _items

    // Method to fetch exercises
    fun getExercises() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                // Launch a coroutine to fetch exercises from the repository
                val exercisesResult = exerciseRepositoryImpl.getExercises()

                // Update the StateFlow with the list of exercises on success
                exercisesResult.onSuccess { exercises ->
                    _items.update {
                        exercises.allExercises
                    }
                }.onFailure {
                    // Handle failure, log, or perform necessary actions
                }
            } catch (e: Exception) {
                // Handle other exceptions if needed
                Log.e("MainViewModel", "Exception in getExercises", e)
            }
        }
    }
}
