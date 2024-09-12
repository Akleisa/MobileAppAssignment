package com.example.app2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app2.R
import com.example.app2.network.AuthRepository
import com.example.app2.network.DashboardResponse
import com.example.app2.network.Plant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize repository
        authRepository = AuthRepository()

        // Get keypass from intent
        val keypass = intent.getStringExtra("KEYPASS")

        if (keypass != null) {
            // Fetch dashboard data
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Error: Keypass missing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        authRepository.getDashboardData(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val dashboardResponse = response.body()!!
                    val plants = dashboardResponse.entities  // Access 'entities', which is the list of plants

                    // Set up the adapter
                    plantAdapter = PlantAdapter(plants) { plant ->
                        // Handle item click - navigate to DetailsActivity
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                        intent.putExtra("PLANT", plant)
                        startActivity(intent)
                    }
                    recyclerView.adapter = plantAdapter
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
