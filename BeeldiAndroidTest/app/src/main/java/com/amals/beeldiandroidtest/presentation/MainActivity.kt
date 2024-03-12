package com.amals.beeldiandroidtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.amals.beeldiandroidtest.R
import com.amals.beeldiandroidtest.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val equipmentViewModel: EquipmentsViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        equipmentViewModel.equipments.observe(this) {
            val adapter = EquipmentListAdapter(it)
            findViewById<RecyclerView>(R.id.equipmentsRecyclerView).adapter = adapter
        }

        equipmentViewModel.error.observe(this) {
            if (it) findViewById<LinearLayout>(R.id.technicalError).visibility = View.VISIBLE
            else findViewById<LinearLayout>(R.id.technicalError).visibility = View.GONE
        }

        equipmentViewModel.errorMessage.observe(this) {
            binding.message.text = it
        }

    }
}