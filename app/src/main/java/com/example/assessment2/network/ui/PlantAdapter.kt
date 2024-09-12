package com.example.app2.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app2.R
import com.example.app2.network.Plant

class PlantAdapter(
    private val plantList: List<Plant>,
    private val onItemClick: (Plant) -> Unit
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        holder.bind(plant, onItemClick)
    }

    override fun getItemCount(): Int = plantList.size

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvScientificName: TextView = itemView.findViewById(R.id.tv_scientific_name)
        private val tvCommonName: TextView = itemView.findViewById(R.id.tv_common_name)
        private val tvCareLevel: TextView = itemView.findViewById(R.id.tv_care_level)
        private val tvLightRequirement: TextView = itemView.findViewById(R.id.tv_light_requirement)

        fun bind(plant: Plant, onItemClick: (Plant) -> Unit) {
            tvScientificName.text = plant.scientificName
            tvCommonName.text = plant.commonName
            tvCareLevel.text = plant.careLevel
            tvLightRequirement.text = plant.lightRequirement
            itemView.setOnClickListener { onItemClick(plant) }
        }
    }
}
