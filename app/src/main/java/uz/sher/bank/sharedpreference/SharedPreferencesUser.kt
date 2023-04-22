package uz.sher.bank.sharedpreference

interface SharedPreferencesUser {
    fun saveAuthToken(token: String)
    fun getAuthToken(): String?
}