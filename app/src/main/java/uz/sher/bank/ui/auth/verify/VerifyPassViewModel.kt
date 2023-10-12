package uz.sher.bank.ui.auth.verify

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.sher.bank.data.network.model.ResponseError
import uz.sher.bank.data.network.model.ResponseModel
import uz.sher.bank.data.network.repository.AuthRepository
import uz.sher.bank.utils.network.NetworkHelper
import uz.sher.bank.utils.resource.Resource
import javax.inject.Inject


@HiltViewModel
class VerifyPassViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {


    private val _verifyResource: MutableLiveData<Resource<ResponseModel>> =
        MutableLiveData()

    val verifyResource get() = _verifyResource


    fun createUser(token: String, code: String) = viewModelScope.launch {

        try {
            _verifyResource.postValue(Resource.loading())

            if (networkHelper.isNetworkConnected()) {
                authRepository.verifyUser("Bearer $token", code).let { response ->

                    _verifyResource.postValue(Resource.error(response.code().toString()))

                    if (response.isSuccessful) {
                        response.body()?.let { body ->
                            if (body.success!!) {
                                _verifyResource.postValue(Resource.success(body, body.message!!))
                            } else {
                                _verifyResource.postValue(Resource.error("Body error: ${body.message}"))
                            }
                        }
                    } else {
                        val gson = Gson()
                        val type = object : TypeToken<ResponseError>() {}.type
                        val errorResponse: ResponseError? =
                            gson.fromJson(response.errorBody()!!.charStream(), type)

                        errorResponse?.let { error ->
                            _verifyResource.postValue(Resource.error("Gson error: ${error.message}"))
                        }

                    }
                }
            } else {
                _verifyResource.postValue(Resource.error("Internetga ulaning"))
            }

        } catch (e: Exception) {
            _verifyResource.postValue(Resource.error("Try catch : ${e.message.toString()}"))
        }


    }
}