package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.RecipientUserItemBinding
import uz.sher.bank.model.Recipient
import uz.sher.bank.utils.functions.CardFunctions

class RecipientAdapter(private val list: MutableList<Recipient>) :
    RecyclerView.Adapter<RecipientAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RecipientUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(recipient: Recipient) {
            binding.recipientUser.text = CardFunctions.nameLetter(recipient.owner)
            binding.recipientUserName.text = recipient.owner
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RecipientUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}