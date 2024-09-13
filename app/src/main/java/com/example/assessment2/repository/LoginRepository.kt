package com.example.assessment2.repository

import com.example.assessment2.data.LoginRequest
import com.example.assessment2.network.ApiService

class LoginRepository(private val apiService: ApiService) {

    // Function to perform login API call
    suspend fun login(username: String, password: String) =
        try {
            // Call the API service with the login request
            apiService.login(LoginRequest(username, password))
        } catch (e: Exception) {
            // Handle any exceptions that might occur during the API call
            throw Exception("Login failed due to an error: ${e.message}")
        }
}
