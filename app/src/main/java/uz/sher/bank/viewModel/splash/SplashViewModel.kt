package uz.sher.bank.viewModel.splash

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.sher.bank.sharedpreference.UserLogin

class SplashViewModel(private val userLogin: UserLogin) : ViewModel() {

    @SuppressLint("SuspiciousIndentation")
    fun isLoggedIn(): MutableLiveData<Boolean> {
        val token = userLogin.getAuthToken()
//          return MutableLiveData(token != null)
        return MutableLiveData(false)

    }
}