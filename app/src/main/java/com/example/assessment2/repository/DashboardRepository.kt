package com.example.assessment2.repository

import com.example.assessment2.network.ApiService
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val apiService: ApiService
) {
    // Function to get dashboard data based on keypass
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}
