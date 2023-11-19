package com.example.mymuscleapp.ui.screen

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.adapteurs.CustomAdapter
import com.google.android.material.textview.MaterialTextView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customAdapter = CustomAdapter(emptyList())

        lifecycleScope.launchWhenStarted {
            try {
                mainViewModel.getExercises().collect { result ->
                    result.onSuccess { exercises ->
                        customAdapter.updateData(exercises.results ?: emptyList())

                        val exerciseCategories = exercises.results?.mapNotNull { exercise ->
                            exercise.category?.name
                        }?.distinct()

                        if (exerciseCategories != null) {
                            for (category in exerciseCategories) {
                                val recyclerView = RecyclerView(this@MainActivity)
                                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

                                val categoryExercises = exercises.results.filter { it.category?.name == category }

                                val adapter = CustomAdapter(categoryExercises)
                                recyclerView.adapter = adapter

                                val categoryTextView = MaterialTextView(this@MainActivity)
                                categoryTextView.text = category
                                categoryTextView.textSize = 18f
                                categoryTextView.setTypeface(null, Typeface.BOLD)
                                categoryTextView.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                                categoryTextView.setPadding(16, 16, 16, 16)
                                categoryTextView.layoutParams = LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                                ).apply {
                                    setMargins(8, 8, 8, 8)
                                }

                                val mainLayout: LinearLayout = findViewById(R.id.mainLayout)

                                val params = LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                                params.setMargins(0, 0, 0, 16)

                                mainLayout.addView(categoryTextView, params)
                                mainLayout.addView(recyclerView)
                            }
                        }
                    }.onFailure { exception ->
                        Log.i("Fail", "Failure")
                        Log.i("Fail message", exception.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Exception in collecting exercises", e)
            }
        }
    }
}
