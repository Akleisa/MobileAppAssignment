package com.example.assessment2.data

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)