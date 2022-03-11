package com.o3interfaces.payanyonetask.utils

import android.view.View

fun View.hide() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.visibility(visible: Boolean) {
    if (visible) visible() else hide()
}