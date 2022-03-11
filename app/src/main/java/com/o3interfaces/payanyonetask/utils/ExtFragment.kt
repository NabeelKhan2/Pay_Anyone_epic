package com.o3interfaces.payanyonetask.utils

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.PaymentSuccessDialogBinding

fun Fragment.changeView(
    titleText: String = "",
    subtitleText: String = "",
) {

    val tvTitle: TextView? = requireActivity().findViewById(R.id.tvTitle)
    val tvSubtitle: TextView? = requireActivity().findViewById(R.id.tvSubtitle)

    if (titleText.isNotEmpty()) {
        tvTitle?.text = titleText
        tvTitle?.visibility = View.VISIBLE
    }

    if (subtitleText.isNotEmpty()) {
        tvSubtitle?.text = subtitleText
        tvSubtitle?.visibility = View.VISIBLE
    } else {
        tvSubtitle?.hide()
    }
}

fun Fragment.setHeaderButton(
    @DrawableRes drawableId: Int = R.drawable.ic_add,
    buttonText: String = "Add"
) {
    val btn: MaterialButton? =
        requireActivity().findViewById(R.id.btnAdd)
    btn?.text = buttonText
    val image = ContextCompat.getDrawable(requireContext(), drawableId)
    image?.run {
        val h: Int = intrinsicHeight
        val w: Int = intrinsicWidth
        image.setBounds(0, 0, w, h)
        btn?.setCompoundDrawables(
            null,
            null,
            this,
            null
        )
    }
}

fun Fragment.headerButtonVisiblity(visible: Boolean) {
    val btn: MaterialButton? =
        requireActivity().findViewById(R.id.btnAdd)
    btn?.apply {
        if (visible) visible() else hide()
    }
}

fun Fragment.bottomNavigationVisibility(visible: Boolean) {
    val bottomNavigation: BottomNavigationView? =
        requireActivity().findViewById(R.id.bottomNavigation)
    bottomNavigation?.apply {
        if (visible) visible() else hide()
    }
}

fun Fragment.showBottomSheetDialog(
    amount: String,
    senderName: String,
    senderAcNo: String,
    receiverName: String,
    receiverAcNo: String,
    date: String,
    action: () -> Unit,
) {
    BottomSheetDialog(requireContext(), R.style.SheetDialog).also { dialog ->
        val binding = PaymentSuccessDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.behavior.isDraggable = false
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.apply {
            tvAmount.text = amount
            tvSenderName.text = senderName
            tvSenderAcNo.text = senderAcNo
            tvReceiverName.text = receiverName
            tvReceiverAcNo.text = receiverAcNo
            tvDate.text = date
            ivCross.setOnClickListener {
                dialog.dismiss()
                action.invoke()
            }
        }
        dialog.show()
    }
}

fun Fragment.navigateWithAnimations(direction: NavDirections) {
    navigate(findNavController(), direction)
}