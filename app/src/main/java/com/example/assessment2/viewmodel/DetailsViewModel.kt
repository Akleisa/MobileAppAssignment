package com.example.assessment2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessment2.data.Entity

class DetailsViewModel : ViewModel() {

    // LiveData to observe selected entity details
    val selectedEntity: MutableLiveData<Entity> = MutableLiveData()

    // Function to set selected entity
    fun setEntity(entity: Entity) {
        selectedEntity.value = entity
    }
}
