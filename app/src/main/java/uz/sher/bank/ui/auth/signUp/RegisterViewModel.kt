package uz.sher.bank.ui.auth.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.sher.bank.data.network.model.ResponseError
import uz.sher.bank.data.network.model.ResponseModel
import uz.sher.bank.data.network.model.SignUpPost
import uz.sher.bank.data.network.repository.AuthRepository
import uz.sher.bank.utils.network.NetworkHelper
import uz.sher.bank.utils.resource.Resource
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _createResource: MutableLiveData<Resource<ResponseModel>> =
        MutableLiveData()

    val createResource get() = _createResource


    fun createUser(signUpPost: SignUpPost) = viewModelScope.launch {

        try {
            _createResource.postValue(Resource.loading())

            if (networkHelper.isNetworkConnected()) {
                authRepository.createUser(signUpPost).let { response ->

                    _createResource.postValue(Resource.error(response.code().toString()))

                    if (response.isSuccessful) {
                        response.body()?.let { body ->
                            if (body.success!!) {
                                _createResource.postValue(Resource.success(body, body.message!!))
                            } else {
                                _createResource.postValue(Resource.error("Body error: ${body.message}"))
                            }
                        }
                    } else {
                        val gson = Gson()
                        val type = object : TypeToken<ResponseError>() {}.type
                        val errorResponse: ResponseError? =
                            gson.fromJson(response.errorBody()!!.charStream(), type)

                        errorResponse?.let { error ->
                            _createResource.postValue(Resource.error("Gson error: ${error.message}"))
                        }

                    }
                }
            } else {
                _createResource.postValue(Resource.error("Internetga ulaning"))
            }

        } catch (e: Exception) {
            _createResource.postValue(Resource.error("Try catch : ${e.message.toString()}"))
        }


    }

}