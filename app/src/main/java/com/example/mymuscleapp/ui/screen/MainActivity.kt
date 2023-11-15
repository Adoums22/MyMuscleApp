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
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val textView: TextView = findViewById(R.id.categoryTitle1)
        val textView2: TextView = findViewById(R.id.categoryTitle2)
        val textView3: TextView = findViewById(R.id.categoryTitle3)
        val recyclerView2: RecyclerView = findViewById(R.id.recycler_view2)
        val recyclerView3: RecyclerView = findViewById(R.id.recycler_view3)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        recyclerView.layoutManager = layoutManager
        recyclerView2.layoutManager = layoutManager2
        recyclerView3.layoutManager = layoutManager3
        customAdapter = CustomAdapter(emptyList()) // Initialize with empty list
        recyclerView.adapter = customAdapter
        recyclerView2.adapter = customAdapter
        recyclerView3.adapter = customAdapter

        lifecycleScope.launchWhenStarted {
            mainViewModel.items.collect { exercises ->
                // Update adapter data when new data arrives
                customAdapter.updateData(exercises)
                val titre = exercises.first().category.name
                textView.text = titre
                /**textView2.text = exercises[1].category.name
                textView3.text = exercises[2].category.name*/
                Log.i("Test", exercises.first().toString())
                Log.i("Test1", titre)
            }
        }

        mainViewModel.getExercises()
    }
}


