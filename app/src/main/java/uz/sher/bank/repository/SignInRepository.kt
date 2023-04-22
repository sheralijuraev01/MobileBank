package uz.sher.bank.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.sher.bank.datasource.RemoteDataSource
import uz.sher.bank.model.ResponseAuth
import uz.sher.bank.model.SignInPost
import uz.sher.bank.sharedpreference.UserLogin
import uz.sher.bank.utils.Resource
import uz.sher.bank.utils.network.NetworkHelper

@RequiresApi(Build.VERSION_CODES.M)
class SignInRepository(
    private val networkHelper: NetworkHelper,
    private val source: RemoteDataSource,
    ) {
    private val signInGet = MutableLiveData<Resource<ResponseAuth>>()


    @OptIn(DelicateCoroutinesApi::class)
    @RequiresApi(Build.VERSION_CODES.M)
    fun getSignInResult(signInPost: SignInPost): MutableLiveData<Resource<ResponseAuth>> {
        /*
        * internet holatini tekshirish kk, undan keyin
        * ma'lumotni coroutines orqali olib kelamiz */

        if (networkHelper.isNetworkConnected()) {
            GlobalScope.launch {
                //holatni loading holat etib belgilash
                signInGet.postValue(Resource.loading())
                try {
                    //coroutine block yaratish
                    coroutineScope {
                        source.getPostSignIn(signInPost).enqueue(object : Callback<ResponseAuth> {
                            override fun onResponse(
                                call: Call<ResponseAuth>,
                                response: Response<ResponseAuth>
                            ) {
                                if (response.isSuccessful) {
                                    val resObj: ResponseAuth? = response.body()
                                    signInGet.postValue(Resource.success(resObj))
                                } else {
                                    signInGet.postValue(Resource.error("The session came without delay"))
                                }
                            }

                            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                                signInGet.postValue(
                                    Resource.error(
                                        t.message ?: "Some error occurred"
                                    )
                                )
                            }
                        })
                    }
                } catch (e: Exception) {
                    // xatolik yuz bersa xatolikni viewmodelga uzatish
                    signInGet.postValue(Resource.error(e.message ?: "Some error occurred"))
                }

            }
        } else {
            // Agar internet yo'q bo'lsa
            signInGet.postValue(Resource.error("Please check your internet"))
        }
        return signInGet
    }





}