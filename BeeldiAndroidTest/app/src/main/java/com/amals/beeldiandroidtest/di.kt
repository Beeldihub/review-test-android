package com.amals.beeldiandroidtest

import com.amals.beeldiandroidtest.data.EquipmentRepositoryImpl
import com.amals.beeldiandroidtest.domain.repository.EquipmentRepository
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val di = module {

    //FirebaseDB
    single { Firebase.database }


    // Repository
    single<EquipmentRepository> { EquipmentRepositoryImpl(get()) }

}
