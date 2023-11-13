package com.example.mymuscleapp.adapteurs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.data.model.AllExercise

class ExerciseAdapter(private val exercises: List<AllExercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.exerciseName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.exerciseDescription)
        // Ajoutez d'autres vues au besoin
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.nameTextView.text = exercise.name
        holder.descriptionTextView.text = exercise.description
        // Mettez à jour d'autres vues au besoin
    }

    override fun getItemCount(): Int {
        return exercises.size
    }
}