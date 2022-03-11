package com.o3interfaces.payanyonetask.ui.fragments.fragmentpayeeslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.o3interfaces.payanyonetask.R
import com.o3interfaces.payanyonetask.databinding.FragmentPayeesListBinding
import com.o3interfaces.payanyonetask.ui.fragments.basefragment.ViewBindingFragment
import com.o3interfaces.payanyonetask.utils.bottomNavigationVisibility
import com.o3interfaces.payanyonetask.utils.changeView
import com.o3interfaces.payanyonetask.utils.headerButtonVisiblity
import com.o3interfaces.payanyonetask.utils.setHeaderButton

class FragmentPayeesList : ViewBindingFragment<FragmentPayeesListBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPayeesListBinding =
        FragmentPayeesListBinding::inflate

    private val groupsAdapter = PayeesAdapter()
    private val viewModel by viewModels<PayeeViewModel>()


    override fun setup() {
        changeView(getString(R.string.my_payees))
        setupRecyclerView()
        headerButtonVisiblity(visible = true)
        setHeaderButton()
        bottomNavigationVisibility(visible = true)
    }

    private fun setupRecyclerView() {
        binding.rvPayees.apply {
            adapter = groupsAdapter
            groupsAdapter.payeeData = viewModel.data
        }
    }
}