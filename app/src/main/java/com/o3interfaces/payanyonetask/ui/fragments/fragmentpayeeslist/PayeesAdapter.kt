package com.o3interfaces.payanyonetask.ui.fragments.fragmentpayeeslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.o3interfaces.payanyonetask.data.PayeeData
import com.o3interfaces.payanyonetask.databinding.ItemUserDetailBinding
import com.o3interfaces.payanyonetask.utils.navigate

class PayeesAdapter : RecyclerView.Adapter<PayeesAdapter.PayeesViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<PayeeData>() {
        override fun areItemsTheSame(oldItem: PayeeData, newItem: PayeeData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PayeeData, newItem: PayeeData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var payeeData: List<PayeeData>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayeesViewHolder {
        val binding =
            ItemUserDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PayeesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return payeeData.size
    }

    override fun onBindViewHolder(holder: PayeesViewHolder, position: Int) {
        holder.bind(payeeData[position])
    }


    class PayeesViewHolder(private val binding: ItemUserDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PayeeData) {
            binding.apply {
                tvUserName.text = item.name
                tvAccount.text = item.accountNo.toString()
                tvBankName.text = item.bankName
                ivProfile.setImageResource(item.image)

                cardView.setOnClickListener {
                    val action =
                        FragmentPayeesListDirections.actionFragmentPayeesListToFragmentPayeeDetail(
                            item
                        )
                    navigate(binding.root.findNavController(), action)
                }
            }
        }
    }
}
