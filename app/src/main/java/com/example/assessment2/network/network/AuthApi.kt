package com.example.assessment2.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path


// Request data class
data class LoginRequest(
    val username: String,
    val password: String
)

// Response data class
data class LoginResponse(
    val keypass: String
)

interface AuthApi {

    @POST("/ort/auth")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>

    // Dashboard API to fetch the list of plants using the keypass
    @GET("/dashboard/{keypass}")
    fun getDashboardData(@Path("keypass") keypass: String): Call<DashboardResponse>
}


