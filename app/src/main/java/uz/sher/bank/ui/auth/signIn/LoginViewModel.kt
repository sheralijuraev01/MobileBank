package uz.sher.bank.ui.auth.signIn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.sher.bank.data.network.model.ResponseError
import uz.sher.bank.data.network.model.ResponseModel
import uz.sher.bank.data.network.model.SignInPost
import uz.sher.bank.data.network.repository.AuthRepository
import uz.sher.bank.utils.network.NetworkHelper
import uz.sher.bank.utils.resource.Resource
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _loginResource: MutableLiveData<Resource<ResponseModel>> =
        MutableLiveData()

    val loginResource get() = _loginResource


    fun loginUser(signInPost: SignInPost) = viewModelScope.launch {

        try {
            _loginResource.postValue(Resource.loading())

            if (networkHelper.isNetworkConnected()) {
                authRepository.loginUser(signInPost).let { response ->

                    _loginResource.postValue(Resource.error(response.code().toString()))

                    if (response.isSuccessful) {
                        response.body()?.let { body ->
                            if (body.success!!) {
                                authRepository.saveToken("Bearer ${body.objectX}")
                                _loginResource.postValue(Resource.success(null, body.message!!))
                            } else {
                                _loginResource.postValue(Resource.error("Body error: ${body.message}"))
                            }
                        }
                    } else {
                        val gson = Gson()
                        val type = object : TypeToken<ResponseError>() {}.type
                        val errorResponse: ResponseError? =
                            gson.fromJson(response.errorBody()!!.charStream(), type)

                        errorResponse?.let { error ->
                            _loginResource.postValue(Resource.error("Gson error: ${error.message}"))
                        }

                    }
                }
            } else {
                _loginResource.postValue(Resource.error("Internetga ulaning"))
            }

        } catch (e: Exception) {
            _loginResource.postValue(Resource.error("Try catch : ${e.message.toString()}"))
        }


    }

}