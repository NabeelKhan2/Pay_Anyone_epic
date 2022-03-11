package com.o3interfaces.payanyonetask.utils

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.o3interfaces.payanyonetask.R
import java.text.SimpleDateFormat
import java.util.*

fun navigate(navController: NavController, direction: NavDirections) {
    navController.navigate(direction, navOption())
}

fun navOption(): NavOptions {
    return NavOptions.Builder()
        .setEnterAnim(R.anim.from_right)
        .setExitAnim(R.anim.to_left)
        .setPopEnterAnim(R.anim.from_left)
        .setPopExitAnim(R.anim.to_right)
        .build()
}

fun currentDate(): String {
    val sdf = SimpleDateFormat("dd MMMM,yyyy", Locale.getDefault())
    val date = Date()
    return sdf.format(date)
}