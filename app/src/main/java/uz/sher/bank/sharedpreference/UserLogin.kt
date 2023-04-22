package uz.sher.bank.sharedpreference

import android.content.SharedPreferences

class UserLogin(private val sharedPreferences: SharedPreferences):SharedPreferencesUser{
    override fun saveAuthToken(token: String) {
        val editor=sharedPreferences.edit()
        editor.putString("auth_token",token)
        editor.apply()
    }

    override fun getAuthToken(): String? {
        return sharedPreferences.getString("auth_token",null)
    }
}