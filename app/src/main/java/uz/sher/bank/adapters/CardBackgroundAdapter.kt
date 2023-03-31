package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.NewCardBackgroundItemBinding
import uz.sher.bank.model.CardBackground

class CardBackgroundAdapter(private val list: MutableList<CardBackground>) :
    RecyclerView.Adapter<CardBackgroundAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: NewCardBackgroundItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(cardBackground: CardBackground) {
            binding.backgroundImage.setBackgroundResource(cardBackground.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            NewCardBackgroundItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}