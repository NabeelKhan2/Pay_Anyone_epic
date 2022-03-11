package com.o3interfaces.payanyonetask.ui.fragments.fragmentpayeeslist

import androidx.lifecycle.ViewModel
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.data.AccountData
import com.o3interfaces.payanyonetask.data.PayeeData
import com.o3interfaces.payanyonetask.data.Purpose

class PayeeViewModel : ViewModel() {

    val data: MutableList<PayeeData> =
        mutableListOf(
            PayeeData("Nabeel", 123456789, "Ubl", R.drawable.profile_image),
            PayeeData("Uzair", 988978778, "Ubl", R.drawable.profile_image),
            PayeeData("Nabeel", 123456789, "Ubl", R.drawable.profile_image)
        )

    val accountList: MutableList<AccountData> =
        mutableListOf(
            AccountData("Nabeel", 123456789, 1000),
            AccountData("Uzair", 12345678910, 20000),
            AccountData("Haris", 12345678911, 300000),
            AccountData("Kamil", 12345678, 400000),
            AccountData("Mubashir", 123456789, 5000),
        )

    val purposeList: MutableList<Purpose> =
        mutableListOf(
            Purpose("charity"),
            Purpose("Government"),
            Purpose("Investments"),
            Purpose("Leisure"),
            Purpose("Loans"),
            Purpose("Personal"),
            Purpose("Rental"),
        )

    val relationList: MutableList<Purpose> =
        mutableListOf(
            Purpose("Corporate Card Payment"),
            Purpose("Credit card Payment")
        )

}