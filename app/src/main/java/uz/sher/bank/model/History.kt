package uz.sher.bank.model

import java.util.*

data class History(
    val senderName: String?,
    val senderCardNumber: String?,
    val receiverName: String?,
    val receiverCardNumber: String?,
    val commission: Double?,
    val amount: Double?,
    val condition: String?,
    val transactionDate: Date?


)



