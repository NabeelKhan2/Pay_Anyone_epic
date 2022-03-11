package com.o3interfaces.payanyonetask.utils.components.paymentreview

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.DrawableRes
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.ComponentPaymentReviewBinding
import java.text.SimpleDateFormat
import java.util.*

class ComponentPaymentReview(
    private val binding: ComponentPaymentReviewBinding,
    @DrawableRes private val icon: Int = R.drawable.ic_person_2,
    private val senderName: String,
    private val senderAccountNo: Long,
    private val receiverName: String,
    private val receiverAccountNo: Long,
    private val receiverBankName: String,
    private val date: String
) {

    private val rvAdapter = AdapterShape()

    init {


        Log.e("this" , date)

        setupRecyclerView()
        binding.apply {
            tvDateText.text = date
            tvUserName.text = senderName
            tvAccountNumber.text = senderAccountNo.toString()
            ivProfile.setImageResource(icon)
            tvName.text = receiverName
            tvAccountNum.text = receiverAccountNo.toString()
            tvBankName.text = receiverBankName
        }
    }


    private fun setupRecyclerView() {
        binding.rvCircleShape.apply {
            adapter = rvAdapter
        }
    }

}