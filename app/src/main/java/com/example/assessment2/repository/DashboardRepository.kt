package com.example.assessment2.repository

import com.example.assessment2.network.ApiService

class DashboardRepository(private val apiService: ApiService) {

    // Function to get dashboard data based on keypass
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}
