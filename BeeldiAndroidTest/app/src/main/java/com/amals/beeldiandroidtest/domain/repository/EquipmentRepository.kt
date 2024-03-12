package com.amals.beeldiandroidtest.domain.repository

import com.amals.beeldiandroidtest.domain.model.Equipment

interface EquipmentRepository {
    suspend fun getEquipmentsList(): Result<ArrayList<Equipment>>
}