package uz.sher.bank.viewModel.auth.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel() : ViewModel() {
    private var firstName: String = ""
    private var lastName: String = ""
    private var email: String = ""
    private var password: String = ""
    private var confirmPassword: String = ""

    private var emailState:MutableLiveData<String> = MutableLiveData("")
    private var firstNameState:MutableLiveData<String> = MutableLiveData("")
    private var lastNameState:MutableLiveData<String> = MutableLiveData("")
    private var passwordState:MutableLiveData<String> = MutableLiveData("")
    private var confPasswordState:MutableLiveData<String> = MutableLiveData("")




    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun setConfPassword(confPassword: String) {
        this.confirmPassword = confPassword
    }

    private fun checkEmail() {

    }

    private fun checkName() {

    }

    private fun checkPassword() {

    }

    private fun checkConfPassword() {

    }

    fun getSignUpState(){

    }

}