package com.example.mymuscleapp.adapteurs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.data.model.Result
import com.example.mymuscleapp.ui.screen.MainActivity
import com.squareup.picasso.Picasso


internal class CustomAdapter(private var itemsListResult: List<Result>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var exerciseNameTextView: TextView = view.findViewById(R.id.exerciseNameTextView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = itemsListResult[position]
        holder.exerciseNameTextView.text = result.name // Mettre à jour le texte avec le nom de l'exercice
        // Chargement de l'image dans l'ImageView avec Picasso
        val imageUrl = "https://cdn-icons-png.flaticon.com/512/2738/2738722.png"
        Picasso.get().load(imageUrl).into(holder.imageView)
        // Mettre en place le clic

    }

    override fun getItemCount(): Int {
        return itemsListResult.size
    }

    fun updateData(newItems: List<Result>) {
        itemsListResult = newItems
        notifyDataSetChanged()
    }
}