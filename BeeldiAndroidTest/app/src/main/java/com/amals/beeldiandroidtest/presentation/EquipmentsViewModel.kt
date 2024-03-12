package com.amals.beeldiandroidtest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amals.beeldiandroidtest.domain.model.Equipment
import com.amals.beeldiandroidtest.domain.repository.EquipmentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EquipmentsViewModel(
    private val repository: EquipmentRepository
) : ViewModel() {

    private val currentEquipmentList = MutableLiveData<List<Equipment>>()

    val equipments = MutableLiveData<List<Equipment>>()
    val error = MutableLiveData(false)
    val errorMessage = MutableLiveData("")

    init {
        getEquipmentsList()
    }

    fun getEquipmentsList() {
        error.value = false
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getEquipmentsList()
            if (result.isSuccess) {
                error.value = false
                currentEquipmentList.value = result.getOrNull()
                equipments.value = currentEquipmentList.value
            } else {
                error.value = true
                errorMessage.value = "Un problème technique est survenu, réessayez ultérieurement"
            }
        }
    }
}
