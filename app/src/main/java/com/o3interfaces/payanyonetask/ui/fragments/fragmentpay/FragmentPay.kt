package com.o3interfaces.payanyonetask.ui.fragments.fragmentpay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.data.AccountData
import com.o3interfaces.payanyonetask.databinding.FragmentPayBinding
import com.o3interfaces.payanyonetask.ui.fragments.basefragment.ViewBindingFragment
import com.o3interfaces.payanyonetask.ui.fragments.fragmentpayeeslist.PayeeViewModel
import com.o3interfaces.payanyonetask.utils.*
import com.o3interfaces.payanyonetask.utils.components.ComponentPayTo
import com.o3interfaces.payanyonetask.utils.components.accountselect.ComponentAccountSelector
import com.o3interfaces.payanyonetask.utils.components.componentpurpose.ComponentPurpose


class FragmentPay : ViewBindingFragment<FragmentPayBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPayBinding =
        FragmentPayBinding::inflate

    private val viewModel by viewModels<PayeeViewModel>()
    private val args by navArgs<FragmentPayArgs>()
    private var accountData: AccountData? = null
    override fun setup() {

        changeView(getString(R.string.pay), getString(R.string.pay_from))
        headerButtonVisiblity(visible = false)
        bottomNavigationVisibility(visible = true)
        ComponentAccountSelector(
            binding.componentAccount,
            viewModel.accountList,
            currentAccount = {
                accountData = it
            },
            action = { isCollapsed ->
                binding.groupAccount.visibility(isCollapsed)
            }
        )

        args.payeeDetail.apply {
            ComponentPayTo(
                binding = binding.componentPayTo,
                name = name,
                accountNo = accountNo,
                bankName = bankName
            )
        }

        ComponentPurpose(
            binding = binding.componentPurpose,
            list = viewModel.purposeList,
            text = getString(R.string.purpose),
            titleText = getString(R.string.purpose_text),
            action = { isCollapsed ->
                binding.groupRelation.visibility(isCollapsed)
            }
        )

        ComponentPurpose(
            binding = binding.componentRelation,
            list = viewModel.relationList,
            text = getString(R.string.relation),
            titleText = getString(R.string.relation_text),
            action = {
                binding.groupPurpose.visibility(it)
            }
        )
        setupButton()
    }

    private fun setupButton() {
        binding.btnComponent.apply {
            btnPay.text = getString(R.string.btn_continue)
            btnPay.setOnClickListener {
                val action =
                    FragmentPayDirections.actionFragmentPayToFragmentAmount(
                        args.payeeDetail,
                        accountData!!
                    )
                navigateWithAnimations(action)
            }
        }
    }
}
