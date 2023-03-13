package uz.sher.bank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.bank.databinding.CardCarouselBinding
import uz.sher.bank.model.Card
import uz.sher.bank.utils.functions.CardFunctions

class CardCarouselAdapter(private val list: MutableList<Card>) :
    RecyclerView.Adapter<CardCarouselAdapter.CarouselItemViewHolder>() {

    inner class CarouselItemViewHolder(val binding: CardCarouselBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(card: Card) {
            binding.cardTypeLogo.setBackgroundResource(card.typeIcon)
            binding.cardBankLogo.setBackgroundResource(card.bankLogo)
            binding.cardName.text = card.cardName
            binding.cardBalance.text = card.balance
            binding.cardBalanceType.text = card.balanceType
            binding.cardNumber.text = CardFunctions.cardNumberEncryptionFormat(card.number)
            binding.cardDate.text = card.date
            binding.cardOwner.text=card.owner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder =
            CardCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
           holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}