package com.example.assessment2.network

import retrofit2.Call

class AuthRepository {

    private val api = RetrofitInstance().apiService

    // Function to make the login request
    fun login(username: String, password: String): Call<LoginResponse> {
        return api.login(LoginRequest(username, password))
    }

    fun getDashboardData(keypass: String): Call<DashboardResponse> {
        return api.getDashboardData(keypass)
    }
}
