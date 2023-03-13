package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.HistoryItemsBinding
import uz.sher.bank.model.History
import uz.sher.bank.utils.functions.CardFunctions
import uz.sher.bank.utils.functions.HistoryFunctions


class HistoryAdapter(private val list: MutableList<History>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: HistoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(history: History) {
            binding.transDate.text=HistoryFunctions.convertLongToTime(1678453655857)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = HistoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}