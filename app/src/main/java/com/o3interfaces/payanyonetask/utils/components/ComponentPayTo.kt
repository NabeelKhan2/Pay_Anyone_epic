package com.o3interfaces.payanyonetask.utils.components

import com.o3interfaces.payanyonetask.databinding.ComponentPayToBinding

class ComponentPayTo(
    binding: ComponentPayToBinding,
    name: String,
    accountNo: Long,
    bankName: String

) {

    init {
        binding.apply {
            tvBankName.text = bankName
            tvName.text = name
            tvAccountNum.text = accountNo.toString()
        }
    }

}