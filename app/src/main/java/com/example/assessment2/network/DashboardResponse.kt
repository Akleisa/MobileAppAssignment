package com.example.assessment2.network

data class DashboardResponse(
    val entities: List<Plant>,  // The list of Plant objects is inside 'entities'
    val entityTotal: Int // total of entities
)