package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.TransferCardCarouselBinding
import uz.sher.bank.model.Card
import uz.sher.bank.utils.functions.CardFunctions

class TransferCardAdapter(private val list: MutableList<Card>) :
    RecyclerView.Adapter<TransferCardAdapter.TransferViewHolder>() {

    inner class TransferViewHolder(val binding: TransferCardCarouselBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(card: Card) {
            binding.transferCardTypeLogo.setBackgroundResource(card.typeIcon)
            binding.transferCardBankLogo.setBackgroundResource(card.bankLogo)
            binding.transferCardName.text=card.cardName
            binding.transferCardNumber.text=CardFunctions.cardNumberLastFormat(card.number)
            binding.transferCardBalance.text=card.balance
            binding.transferCardBalanceType.text=card.balanceType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder {
        val view =
            TransferCardCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransferViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
      holder.onBind(list[position])
    }


}