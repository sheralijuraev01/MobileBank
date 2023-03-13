package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.AllRecipientsUserItemBinding
import uz.sher.bank.model.Recipient
import uz.sher.bank.utils.functions.CardFunctions

class AllRecipientsAdapter(private val list: MutableList<Recipient>) :
    RecyclerView.Adapter<AllRecipientsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: AllRecipientsUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(recipient: Recipient) {
            binding.allRecipientsUser.text = CardFunctions.nameLetter(recipient.owner)
            binding.allRecipientsUserName.text = recipient.owner
            if (recipient.cardNumber == "") {
                binding.allRecipientsUserCardNumber.visibility = View.GONE
            } else {
                binding.allRecipientsUserCardNumber.text = recipient.cardNumber
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            AllRecipientsUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}