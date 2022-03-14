package com.o3interfaces.payanyonetask.ui.fragments.fragmentpaymentreview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.FragmentReviewPaymentBinding
import com.o3interfaces.payanyonetask.ui.fragments.basefragment.ViewBindingFragment
import com.o3interfaces.payanyonetask.utils.*
import com.o3interfaces.payanyonetask.utils.components.paymentreview.ComponentPaymentReview

class FragmentReviewPayment : ViewBindingFragment<FragmentReviewPaymentBinding>() {

    private val args by navArgs<FragmentReviewPaymentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentReviewPaymentBinding
        get() = FragmentReviewPaymentBinding::inflate


    @SuppressLint("SetTextI18n")
    override fun setup() {

        changeView("Review\nPayment")
        bottomNavigationVisibility(visible = false)
        headerButtonVisiblity(true)
        setHeaderButton(R.drawable.ic_schedule, getString(R.string.schedule))

        with(args) {
            ComponentPaymentReview(
                binding.componentRev,
                senderName = senderData.holderName,
                senderAccountNo = senderData.accountNumber,
                receiverName = receiverData.name,
                receiverAccountNo = receiverData.accountNo,
                receiverBankName = receiverData.bankName,
                date = currentDate()
            )
            binding.tvAmount.text = "$amount.00"
        }

        binding.componentButton.btnPay.apply {
            text = getString(R.string.proceed_to_pay)
            setOnClickListener {
                with(args) {
                    showBottomSheetDialog(
                        amount = "$amount.00",
                        senderName = senderData.holderName,
                        senderAcNo = senderData.accountNumber.toString(),
                        receiverName = receiverData.name,
                        receiverAcNo = receiverData.accountNo.toString(),
                        date = currentDate(),
                        action = {
                            val action =
                                FragmentReviewPaymentDirections.actionFragmentReviewPaymentToFragmentPayeesList()
                            findNavController().navigate(action)
                        }
                    )
                }
            }
        }
    }
}

