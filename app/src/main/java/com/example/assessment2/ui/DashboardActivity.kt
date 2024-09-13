package com.example.assessment2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2.R
import com.example.assessment2.data.Entity
import com.example.assessment2.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint  // Annotate with AndroidEntryPoint for Hilt injection
class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter

    // Use Hilt to inject ViewModel without manually creating it
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize adapter and set it to RecyclerView
        entityAdapter = EntityAdapter(emptyList()) { entity -> onEntityClick(entity) }
        recyclerView.adapter = entityAdapter

        // Get keypass from intent
        val keypass = intent.getStringExtra("keypass")

        // Fetch and observe dashboard data
        if (keypass != null) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Error: Keypass missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        // Fetch data from ViewModel
        dashboardViewModel.getDashboardData(keypass)

        // Observe the dashboard data from ViewModel
        dashboardViewModel.dashboardData.observe(this) { dashboardResponse ->
            if (dashboardResponse != null) {
                // Update the adapter with the new data
                entityAdapter.updateList(dashboardResponse.entities)
            } else {
                // Show an error message if data loading failed
                Toast.makeText(this, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onEntityClick(entity: Entity) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("selectedEntity", entity)  // Pass the Parcelable entity
        startActivity(intent)
    }
}
