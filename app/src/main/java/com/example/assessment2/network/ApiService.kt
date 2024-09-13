package com.example.assessment2.network

import com.example.assessment2.data.LoginRequest
import com.example.assessment2.data.LoginResponse
import com.example.assessment2.data.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    // POST request for login
    @POST("/ort/auth")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    // GET request for dashboard data
    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}
