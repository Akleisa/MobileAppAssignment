package com.example.assessment2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assessment2.repository.DashboardRepository

class DashboardViewModelFactory(private val dashboardRepository: DashboardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(dashboardRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
