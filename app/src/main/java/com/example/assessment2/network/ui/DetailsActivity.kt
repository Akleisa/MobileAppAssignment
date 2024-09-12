package com.example.app2.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app2.R
import com.example.app2.network.Plant

class DetailsActivity : AppCompatActivity() {

    private lateinit var tvScientificName: TextView
    private lateinit var tvCommonName: TextView
    private lateinit var tvCareLevel: TextView
    private lateinit var tvLightRequirement: TextView
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize views
        tvScientificName = findViewById(R.id.tv_scientific_name)
        tvCommonName = findViewById(R.id.tv_common_name)
        tvCareLevel = findViewById(R.id.tv_care_level)
        tvLightRequirement = findViewById(R.id.tv_light_requirement)
        tvDescription = findViewById(R.id.tv_description)

        // Get the Plant object passed from DashboardActivity
        val plant = intent.getParcelableExtra<Plant>("PLANT")

        // Set the plant details on the views
        plant?.let {
            tvScientificName.text = it.scientificName
            tvCommonName.text = it.commonName
            tvCareLevel.text = it.careLevel
            tvLightRequirement.text = it.lightRequirement
            tvDescription.text = it.description
        }
    }
}
