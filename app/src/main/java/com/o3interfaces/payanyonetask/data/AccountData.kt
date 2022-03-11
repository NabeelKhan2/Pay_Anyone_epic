package com.o3interfaces.payanyonetask.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountData(
    val holderName: String,
    val accountNumber: Long,
    val amount: Long
) : Parcelable
