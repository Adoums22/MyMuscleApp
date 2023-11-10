package com.example.mymuscleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Log
import com.example.mymuscleapp.model.ExerciseHttpClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Appel de la fonction getExerciseHttpClient dans une coroutine pour les opérations asynchrones
        GlobalScope.launch(Dispatchers.Main) {
            val exercise = withContext(Dispatchers.IO) {
                try {
                    // Appel de la fonction du client HTTP pour récupérer la blague geek
                    ExerciseHttpClient().getExerciseHttpClient()
                } catch (e: Exception) {
                    Log.e("MainActivity", "Erreur lors de la récupération de la blague", e)
                    null // En cas d'erreur, renvoie null
                }
            }

            // Utilisation des logs pour afficher la blague dans la console
            exercise?.let {
                Log.d("MainActivity", "Blague Geek: ${it}")
            } ?: Log.d("MainActivity", "La récupération de la blague a échoué.")
        }
    }
}
