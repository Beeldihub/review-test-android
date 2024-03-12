package com.amals.beeldiandroidtest.data

import com.amals.beeldiandroidtest.domain.model.Equipment
import com.amals.beeldiandroidtest.domain.repository.EquipmentRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase


class EquipmentRepositoryImpl(private val firebaseDatabase: FirebaseDatabase) :
    EquipmentRepository {

    private val firebaseDbReference = firebaseDatabase.getReference("Equipments")

    override suspend fun getEquipmentsList(): Result<ArrayList<Equipment>> {
        val response = firebaseDbReference.get()
        return when (response.isSuccessful) {
            true -> {
                val equipments = ArrayList<Equipment>()
                for (userSnapshot in response.result.children) {
                    val userModel = userSnapshot.getValue(Equipment::class.java)
                    userModel?.id = userSnapshot.key.orEmpty()
                    equipments.add(userModel!!)
                }
                Result.success(equipments)
            }
            else -> Result.failure(response.exception!!)
        }
    }
}