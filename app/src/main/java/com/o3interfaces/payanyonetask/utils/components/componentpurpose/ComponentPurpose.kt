package com.o3interfaces.payanyonetask.utils.components.componentpurpose

import androidx.core.view.isVisible
import com.o3interfaces.payanyonetask.data.Purpose
import com.o3interfaces.payanyonetask.databinding.ComponentPurposeBinding
import com.o3interfaces.payanyonetask.utils.hide
import com.o3interfaces.payanyonetask.utils.visible

class ComponentPurpose(
    private val binding: ComponentPurposeBinding,
    private val list: List<Purpose>,
    private val action: ((Boolean) -> Unit)? = null,
    text: String,
    titleText: String
) {
    private var purposeAdapter = PurposeAdapter()

    init {
        setupRecyclerView()
        showAndHideComponent()
        binding.tvPurpose.text = text
        binding.tvLabel.text = titleText
    }

    private fun showAndHideComponent() {
        binding.apply {
            cardView.setOnClickListener {
                action?.invoke(group4.isVisible)
                if (group3.isVisible) {
                    group3.hide()
                    group4.visible()
                } else {
                    group3.visible()
                    group4.hide()
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvAccounts.apply {
            adapter = purposeAdapter
            purposeAdapter.accountData = list
            purposeAdapter.onItemClick = { accountData ->
                binding.apply {
                    tvLabel.text = accountData.purpose
                    group4.hide()
                    action?.invoke(true)
                    group3.visible()
                }
            }
        }
    }
}
