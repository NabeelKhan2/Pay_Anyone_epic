package com.o3interfaces.payanyonetask.utils.components

import com.o3interfaces.payanyonetask.databinding.ComponentCardViewBinding

class CardViewComponent(
    binding: ComponentCardViewBinding,
    private val icon: Int,
    private val name: String,
    private val accountNo: Long,
    private val bankName: String
) {
    init {
        binding.apply {
            ivProfile.setImageResource(icon)
            tvBankName.text = bankName
            tvName.text = name
            tvAccountNum.text = accountNo.toString()
        }
    }
}