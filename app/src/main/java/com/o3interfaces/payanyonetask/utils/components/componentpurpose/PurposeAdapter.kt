package com.o3interfaces.payanyonetask.utils.components.componentpurpose

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.o3interfaces.payanyonetask.data.Purpose
import com.o3interfaces.payanyonetask.databinding.ItemPurposeBinding

class PurposeAdapter : RecyclerView.Adapter<PurposeAdapter.AccountViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Purpose>() {
        override fun areItemsTheSame(oldItem: Purpose, newItem: Purpose): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Purpose, newItem: Purpose): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var accountData: List<Purpose>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding =
            ItemPurposeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return accountData.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accountData[position])
    }

    var onItemClick: ((Purpose) -> Unit)? = null

    inner class AccountViewHolder(private val binding: ItemPurposeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Purpose) {
            binding.apply {
                tvLabel.text = item.purpose

                cardView.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }
}
