package com.example.mymuscleapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymuscleapp.data.model.AllExercise
import com.example.mymuscleapp.data.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val exerciseRepository: ExerciseRepository) : ViewModel() {
    private val _items: MutableStateFlow<List<AllExercise>> = MutableStateFlow(emptyList())
    val items: StateFlow<List<AllExercise>> = _items
    // Méthode pour obtenir les exercices
    fun getExercises() {
        viewModelScope.launch(Dispatchers.Main) {
            viewModelScope.launch {
                exerciseRepository.getExercises().onSuccess { exercisesResult ->
                    _items.update {
                        exercisesResult.allExercises
                    }
                }.onFailure {
                    // something went wrong
                }
            }
        }
    }
}