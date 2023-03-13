package uz.sher.bank.model

data class Card(
    val typeIcon: Int,
    val bankLogo: Int,
    val cardName: String,
    val balance: String,
    val balanceType: String,
    val owner: String,
    val number: String,
    val date: String
)