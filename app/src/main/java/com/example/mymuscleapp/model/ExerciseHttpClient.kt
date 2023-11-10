// Importation des classes nécessaires
package com.example.mymuscleapp.model

import com.example.mymuscleapp.data.Exercise
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import io.ktor.client.request.get

// Classe représentant un client HTTP pour récupérer des blagues geek depuis l'API
class ExerciseHttpClient {
    // Initialisation du client HTTP avec le moteur CIO
    private val client = HttpClient(CIO) {
        // Configuration du support JSON avec le sérialiseur Kotlinx
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json { ignoreUnknownKeys = true })
        }
    }

    // Fonction suspendue pour obtenir une blague geek depuis l'API
    suspend fun getExerciseHttpClient(): Exercise {
        // Effectue une requête GET à l'URL de l'API et renvoie une blague geek
        return client.get("https://wger.de/api/v2/exercise/?language=2")
    }
}
