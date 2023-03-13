package uz.sher.bank.fake_data

import uz.sher.bank.R
import uz.sher.bank.model.Card
import uz.sher.bank.model.History
import uz.sher.bank.model.Recipient

class Data {
    companion object {
        private var cardList: MutableList<Card> = ArrayList()
        private var cardRecipientList: MutableList<Recipient> = ArrayList()
        private var historyList: MutableList<History> = ArrayList()


        fun getHistoryData(): MutableList<History> {
            historyList.clear()

            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            historyList.add(
                History(
                    "Sherali Jo'rayev",
                    "8600332996741405",
                    "Aliyev Botir",
                    "8600332996741405",
                    120000.0,
                    1200.0,
                    "send",
                    null
                )
            )
            return historyList
        }

        fun getCardList(): MutableList<Card> {
            cardList.clear()
            cardList.add(
                Card(
                    R.drawable.uzcad_logo,
                    R.drawable.ipoteka_icon,
                    "Business",
                    "120 230.52",
                    "so\'m",
                    "ShERALI JURAEV",
                    "8600332996741405",
                    "12/24"
                )
            )
            cardList.add(
                Card(
                    R.drawable.uzcad_logo,
                    R.drawable.ipoteka_icon,
                    "Business",
                    "120 230.52",
                    "so\'m",
                    "ShERALI JURAEV",
                    "8600332996741405",
                    "12/24"
                )
            )
            cardList.add(
                Card(
                    R.drawable.uzcad_logo,
                    R.drawable.ipoteka_icon,
                    "Business",
                    "120 230.52",
                    "so\'m",
                    "ShERALI JURAEV",
                    "8600332996741405",
                    "12/24"
                )
            )
            cardList.add(
                Card(
                    R.drawable.uzcad_logo,
                    R.drawable.ipoteka_icon,
                    "Business",
                    "120 230.52",
                    "so\'m",
                    "SHERALI JURAEV",
                    "8600332996741405",
                    "12/24"
                )
            )
            return cardList
        }

        fun getCardRecipientList(): MutableList<Recipient> {
            cardRecipientList.clear()
            cardRecipientList.add(
                Recipient(
                    "Sherali Jo'rayev",
                    "sher.jorayev01@gmail.com",
                    "8600332996741405"
                )
            )
            cardRecipientList.add(Recipient("Akmal Qo'ziyev", "sher.jorayev01@gmail.com", "123456"))
            cardRecipientList.add(
                Recipient(
                    "Shaxzod Murtazaqulov",
                    "sher.jorayev01@gmail.com",
                    "8600332996741405"
                )
            )
            cardRecipientList.add(Recipient("Feruz Jo'rayev", "sher.jorayev01@gmail.com", "123456"))
            cardRecipientList.add(
                Recipient(
                    "Javohir Pardayev",
                    "sher.jorayev01@gmail.com",
                    "8600332996741405"
                )
            )
            cardRecipientList.add(Recipient("Sarvar Sanayev", "sher.jorayev01@gmail.com", "123456"))
            cardRecipientList.add(
                Recipient(
                    "Habibullo Hikmatov",
                    "sher.jorayev01@gmail.com",
                    "8600332996741405"
                )
            )
            cardRecipientList.add(Recipient("Usmon Boltayev", "sher.jorayev01@gmail.com", "8600332996741405"))
            cardRecipientList.add(Recipient("Add Recipient", "sher.jorayev01@gmail.com", "8600332996741405"))

            return cardRecipientList
        }
    }
}