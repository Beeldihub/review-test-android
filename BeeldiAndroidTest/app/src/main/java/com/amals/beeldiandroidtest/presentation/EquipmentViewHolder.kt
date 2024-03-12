package com.amals.beeldiandroidtest.presentation

import androidx.recyclerview.widget.RecyclerView
import com.amals.beeldiandroidtest.R
import com.amals.beeldiandroidtest.databinding.EquipmentItemBinding
import com.amals.beeldiandroidtest.domain.model.Equipment

class EquipmentViewHolder(private val binding: EquipmentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Equipment) {
        binding.domainMaterialTextView.text = item.domain
        binding.nameMaterialTextView.text = item.name
        binding.faultMaterialTextView.text = if (item.nbFaults > 1) "${
            itemView.context.getString(
                R.string.equipment_fault_number_plural,

                )
        } ${item.nbFaults}"
        else "${
            itemView.context.getString(
                R.string.equipment_fault_number,

                )
        } ${item.nbFaults}"
    }
}