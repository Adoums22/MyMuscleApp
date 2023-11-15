package com.example.mymuscleapp.adapteurs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuscleapp.R
import com.example.mymuscleapp.data.model.Result

internal class CustomAdapter(private var itemsListResult: List<Result>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var exerciseNameTextView: TextView = view.findViewById(R.id.exerciseNameTextView)
        var equipmentTextView: TextView = view.findViewById(R.id.equipmentTextView)
        var categoryTextView: TextView = view.findViewById(R.id.categoryTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = itemsListResult[position]
        holder.exerciseNameTextView.text = "Name: ${result.name}"

        // Affichage des équipements
        val equipmentStringBuilder = StringBuilder()
        for (equipment in result.equipment) {
            equipmentStringBuilder.append("${equipment.name}, ")
        }
        val equipmentText = equipmentStringBuilder.toString().trimEnd(',', ' ')
        holder.equipmentTextView.text = "Equipment: $equipmentText"

        // Affichage de la catégorie
        holder.categoryTextView.text = "${result.category.name}"
    }


    override fun getItemCount(): Int {
        return itemsListResult.size
    }

    fun updateData(newItems: List<Result>) {
        itemsListResult = newItems
        notifyDataSetChanged()
    }
}