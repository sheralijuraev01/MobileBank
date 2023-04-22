package uz.sher.bank.viewModel.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.sher.bank.repository.SignInRepository
import uz.sher.bank.sharedpreference.UserLogin

//view modelga repositryni biriktirish uchun bu classni ochdik
class SplashViewModelFactory(private val userLogin: UserLogin) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //view modelni konstruktriga repositoryni biritirish
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(userLogin) as T
        }
        throw java.lang.IllegalArgumentException("Error occurred")
    }
}