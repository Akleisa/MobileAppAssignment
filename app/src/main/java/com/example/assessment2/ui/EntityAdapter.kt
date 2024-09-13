package com.example.assessment2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.data.Entity

class EntityAdapter(
    private var entityList: List<Entity>,  // Mutable property for updating data
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.bind(entity, onItemClick)
    }

    override fun getItemCount(): Int = entityList.size

    // Method to update the entity list and notify the adapter
    fun updateList(newList: List<Entity>) {
        entityList = newList
        notifyDataSetChanged()  // Notify adapter about data change
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvScientificName: TextView = itemView.findViewById(R.id.tv_scientific_name)
        private val tvCommonName: TextView = itemView.findViewById(R.id.tv_common_name)
        private val tvCareLevel: TextView = itemView.findViewById(R.id.tv_care_level)
        private val tvLightRequirement: TextView = itemView.findViewById(R.id.tv_light_requirement)

        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            tvScientificName.text = entity.scientificName
            tvCommonName.text = entity.commonName
            tvCareLevel.text = entity.careLevel
            tvLightRequirement.text = entity.lightRequirement
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}
