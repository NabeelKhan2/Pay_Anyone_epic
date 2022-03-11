package com.o3interfaces.payanyonetask.ui.fragments.fragmentpayeedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.FragmentPayeeDetailBinding
import com.o3interfaces.payanyonetask.ui.fragments.basefragment.ViewBindingFragment
import com.o3interfaces.payanyonetask.utils.bottomNavigationVisibility
import com.o3interfaces.payanyonetask.utils.changeView
import com.o3interfaces.payanyonetask.utils.components.CardViewComponent
import com.o3interfaces.payanyonetask.utils.headerButtonVisiblity
import com.o3interfaces.payanyonetask.utils.navigateWithAnimations

class FragmentPayeeDetail : ViewBindingFragment<FragmentPayeeDetailBinding>() {

    private val args by navArgs<FragmentPayeeDetailArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPayeeDetailBinding =
        FragmentPayeeDetailBinding::inflate

    override fun setup() {

        args.payeeDetail.apply {
            CardViewComponent(
                binding = binding.cardView,
                icon = image,
                name = name,
                accountNo = accountNo,
                bankName = bankName
            )
        }

        binding.componentBtnPay.apply {
            btnPay.text = getString(R.string.pay_now)
            btnPay.setOnClickListener {
                val action =
                    FragmentPayeeDetailDirections.actionFragmentPayeeDetailToFragmentPay(
                        args.payeeDetail
                    )
                navigateWithAnimations(action)
            }
        }

        changeView("Payee Details")
        headerButtonVisiblity(visible = false)
        bottomNavigationVisibility(visible = true)
    }
}