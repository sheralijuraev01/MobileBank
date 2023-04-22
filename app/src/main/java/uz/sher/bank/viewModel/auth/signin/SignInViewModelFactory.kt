package uz.sher.bank.viewModel.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.sher.bank.repository.SignInRepository

//view modelga repositryni biriktirish uchun bu classni ochdik
class SignInViewModelFactory(private val signInRepository: SignInRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //view modelni konstruktriga repositoryni biritirish
        if(modelClass.isAssignableFrom(SignInViewModel::class.java)){
            return SignInViewModel(signInRepository) as T
        }
        throw java.lang.IllegalArgumentException("Error occurred")
    }
}