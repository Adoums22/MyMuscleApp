package com.example.mymuscleapp.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mymuscleapp.data.model.ApiResponse
import com.example.mymuscleapp.data.model.Result
import com.example.mymuscleapp.data.repository.ExerciseRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel(private val exerciseRepositoryImpl: ExerciseRepositoryImpl) : ViewModel() {

    // MutableStateFlow to hold the list of exercises
    private val _items: MutableStateFlow<List<Result>> = MutableStateFlow(emptyList())


    // StateFlow to observe the list of exercises
    val items: StateFlow<List<Result>> = _items

    // Method to fetch exercises
    fun getExercises(): Flow<kotlin.Result<ApiResponse>> = flow {
        try {
            // Fetch exercises from the repository
            val exercisesResult = exerciseRepositoryImpl.getExercises()

            // Emit the result to the Flow
            emit(exercisesResult)

            exercisesResult.onSuccess { exercises ->
                // Update the StateFlow with the list of exercises on success
                _items.value = exercises.results ?: emptyList()
            }
        } catch (e: Exception) {
            // Handle other exceptions if needed
            Log.e("MainViewModel", "Exception in getExercises", e)
        }
    }.flowOn(Dispatchers.IO)

    fun getEquipments() {
        Log.i("MesEquipement 1", items.value.toString())
        items.value.forEach {
            Log.i("MesEquipement 0", it.equipment.toString())
        }
    }
}