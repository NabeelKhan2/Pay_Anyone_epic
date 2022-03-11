package com.o3interfaces.payanyonetask.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PayeeData(
    val name: String,
    val accountNo: Long,
    val bankName: String,
    @DrawableRes val image: Int
) : Parcelable
