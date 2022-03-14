package com.o3interfaces.payanyonetask.ui.fragments.fragmentamount

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.FragmentAmountBinding
import com.o3interfaces.payanyonetask.ui.fragments.basefragment.ViewBindingFragment
import com.o3interfaces.payanyonetask.utils.bottomNavigationVisibility
import com.o3interfaces.payanyonetask.utils.changeView
import com.o3interfaces.payanyonetask.utils.headerButtonVisiblity
import com.o3interfaces.payanyonetask.utils.navigateWithAnimations

class FragmentAmount : ViewBindingFragment<FragmentAmountBinding>() {

    private val args by navArgs<FragmentAmountArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAmountBinding
        get() = FragmentAmountBinding::inflate

    override fun setup() {
        changeView(getString(R.string.pay), args.payeeDetail.name)
        bottomNavigationVisibility(visible = false)
        headerButtonVisiblity(visible = false)
        setupButton()
    }

    private fun setupButton() {
        binding.btnComponent.apply {
            btnPay.text = getString(R.string.proceed_to_pay)
            btnPay.setOnClickListener {
                val amount = binding.etAmount.text.toString()
                if (amount.isNotEmpty()) {
                    val action =
                        FragmentAmountDirections.actionFragmentAmountToFragmentReviewPayment(
                            amount,
                            args.accountData,
                            args.payeeDetail
                        )
                    navigateWithAnimations(action)
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.fill_out),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}