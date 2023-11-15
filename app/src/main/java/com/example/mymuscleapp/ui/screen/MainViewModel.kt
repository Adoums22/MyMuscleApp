package com.example.mymuscleapp.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymuscleapp.data.model.Result
import com.example.mymuscleapp.data.repository.ExerciseRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val exerciseRepositoryImpl: ExerciseRepositoryImpl) : ViewModel() {

    // MutableStateFlow to hold the list of exercises
    private val _items: MutableStateFlow<List<Result>> = MutableStateFlow(emptyList())


    // StateFlow to observe the list of exercises
    val items: StateFlow<List<Result>> = _items

    // Method to fetch exercises
    fun getExercises() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                // Launch a coroutine to fetch exercises from the repository
                val exercisesResult = exerciseRepositoryImpl.getExercises()

                // Update the StateFlow with the list of exercises on success
                exercisesResult.onSuccess { exercises ->
                    _items.update {
                        exercises.results
                    }
                }.onFailure {
                    // Handle failure, log, or perform necessary actions
                    Log.i("Fail", "Failure")
                    Log.i("Fail message", it.toString())
                }
            } catch (e: Exception) {
                // Handle other exceptions if needed
                Log.e("MainViewModel", "Exception in getExercises", e)
            }
        }
    }
    fun getEquipments() {
        Log.i("MesEquipement 1", items.value.toString())
        items.value.forEach {
            Log.i("MesEquipement 0", it.equipment.toString())
        }
    }
}