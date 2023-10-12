package uz.sher.bank.utils.functions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class  HistoryFunctions {
    companion object{
        @SuppressLint("SimpleDateFormat")
        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
            return format.format(date)
        }
    }
}