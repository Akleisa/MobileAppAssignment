package com.example.assessment2.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2.R
import com.example.assessment2.data.Entity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get the selected entity from the intent
        val selectedEntity = intent.getParcelableExtra<Entity>("selectedEntity")

        // Initialize the views
        val tvScientificName = findViewById<TextView>(R.id.tv_scientific_name)
        val tvCommonName = findViewById<TextView>(R.id.tv_common_name)
        val tvCareLevel = findViewById<TextView>(R.id.tv_care_level)
        val tvLightRequirement = findViewById<TextView>(R.id.tv_light_requirement)
        val tvDescription = findViewById<TextView>(R.id.tv_description)

        // Set the data to the views
        selectedEntity?.let {
            tvScientificName.text = it.scientificName
            tvCommonName.text = it.commonName
            tvCareLevel.text = it.careLevel
            tvLightRequirement.text = it.lightRequirement
            tvDescription.text = it.description
        }
    }
}
