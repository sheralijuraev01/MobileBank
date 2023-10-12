package uz.sher.bank.data.local.sharedPref

import android.content.Context
import uz.sher.bank.utils.constant.SharedConstants.SHARED_LANGUAGE
import uz.sher.bank.utils.constant.SharedConstants.SHARED_PREF_NAME
import uz.sher.bank.utils.constant.SharedConstants.SHARED_USER_TOKEN


class SharedPrefRepository(context: Context) : SharedPreference {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun getToken(): String {
        return sharedPreferences.getString(SHARED_USER_TOKEN, "") ?: ""
    }

    override suspend fun saveToken(token: String) {
        sharedPreferences.edit().putString(SHARED_USER_TOKEN, token).apply()
    }

    override fun saveLang(lang: String) {
        sharedPreferences.edit().putString(SHARED_LANGUAGE, lang).apply()
    }

    override fun getLang(): String {
        return sharedPreferences.getString(SHARED_LANGUAGE, "ru") ?: "ru"
    }


}