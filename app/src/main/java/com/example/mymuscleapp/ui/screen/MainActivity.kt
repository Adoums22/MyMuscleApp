package com.example.mymuscleapp.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.adapteurs.ExerciseAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var exerciseAdapter: ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        exerciseAdapter = ExerciseAdapter()
        recyclerView.adapter = exerciseAdapter

        // Observer for LiveData in ViewModel
        mainViewModel.items.observe(this, { exercises ->
            // Update the adapter with the new list of exercises
            exerciseAdapter.submitList(exercises)
        })

        // Call the method in the ViewModel to fetch exercises
        mainViewModel.getExercises()
    }
}
