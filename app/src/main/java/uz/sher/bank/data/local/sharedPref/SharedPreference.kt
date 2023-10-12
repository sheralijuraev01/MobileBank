package uz.sher.bank.data.local.sharedPref

interface SharedPreference {
    fun getToken(): String

    suspend fun saveToken(token: String)

    fun saveLang(lang: String)

    fun getLang(): String
}