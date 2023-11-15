package com.example.mymuscleapp.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.adapteurs.CustomAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var customAdapter: CustomAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        // TODO : dynamic recyclerView for each categorie PLEASE !!! important

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val textView: TextView = findViewById(R.id.categoryTitle1)
        val textView2: TextView = findViewById(R.id.categoryTitle2)
        val textView3: TextView = findViewById(R.id.categoryTitle3)
        val recyclerView2: RecyclerView = findViewById(R.id.recycler_view2)
        val recyclerView3: RecyclerView = findViewById(R.id.recycler_view3)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // TODO : dynamic recyclerView for each categorie PLEASE !!! important
        recyclerView.layoutManager = layoutManager
        recyclerView2.layoutManager = layoutManager2
        recyclerView3.layoutManager = layoutManager3
        customAdapter = CustomAdapter(emptyList()) // Initialize with empty list

        // TODO : dynamic recyclerView for each categorie PLEASE !!! important
        recyclerView.adapter = customAdapter
        recyclerView2.adapter = customAdapter
        recyclerView3.adapter = customAdapter

        lifecycleScope.launchWhenStarted {
            try {
                mainViewModel.getExercises().collect { result ->
                    // Handle the result of fetching exercises
                    result.onSuccess { exercises ->
                        Log.i("Succees", exercises.toString())
                        customAdapter.updateData(exercises.results ?: emptyList())

                        // TODO : dynamic titles for each categorie PLEASE !!! important
                        textView.text = exercises.results?.get(0)?.category?.name ?: ""
                        textView2.text = exercises.results?.get(1)?.category?.name ?: ""
                        textView3.text = exercises.results?.get(2)?.category?.name ?: ""
                    }.onFailure { exception ->
                        // Handle failure, log, or perform necessary actions
                        Log.i("Fail", "Failure")
                        Log.i("Fail message", exception.toString())
                    }
                }
            } catch (e: Exception) {
                // Handle exceptions if needed
                Log.e("MainActivity", "Exception in collecting exercises", e)
            }
        }
    }
}


