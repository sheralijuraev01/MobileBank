package uz.sher.bank.utils.functions

class CardFunctions {
    companion object {
        fun nameLetter(string: String): String {
            if (string == "Add Recipient") return "+"
            var result = ""
            val index = string.indexOf(" ")
            result += string[0]
            result += string[index + 1]
            return result
        }

        fun cardNumberFormat(cardNumber: String?): String {
            if (cardNumber == null || cardNumber.length != 16) return "Xatolik"
            val result = StringBuilder()

            for (i in 0..3) {
                result.append(cardNumber.substring(i * 4, (i + 1) * 4))
                if (i != 3) result.append(" ")
            }
            return result.toString()
        }

        //Encryption- shifrlash
        fun cardNumberEncryptionFormat(cardNumber: String?): String {
            val formatCardNumber = cardNumberFormat(cardNumber)
            val resultEncryption = StringBuilder()
            for (i in 0..18) {
                if (i in 7..13) {
                    if (i == 9) resultEncryption.append(" ")
                    else resultEncryption.append("*")
                } else resultEncryption.append(formatCardNumber[i])
            }

            return resultEncryption.toString()

        }

        fun cardNumberLastFormat(cardNumber: String?): String {
            val result = cardNumberEncryptionFormat(cardNumber)
            return result.substring(10, 19)

        }

    }
}