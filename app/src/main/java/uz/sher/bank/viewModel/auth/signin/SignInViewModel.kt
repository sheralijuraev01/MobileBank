package uz.sher.bank.viewModel.auth.signin

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.sher.bank.model.ResponseAuth
import uz.sher.bank.model.SignInPost
import uz.sher.bank.repository.SignInRepository
import uz.sher.bank.utils.Resource

class SignInViewModel(private val signInRepository: SignInRepository) : ViewModel() {
    private lateinit var _signInPost: SignInPost
    private var email: String = ""
    private var password: String = ""

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun getAllPosts(): MutableLiveData<Resource<ResponseAuth>> {
        return signInRepository.getSignInResult(_signInPost)
    }

    fun areFieldsEmpty(): Boolean {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            _signInPost = SignInPost(email, password)
            return true
        }
        return false
    }
}