package uz.sher.bank.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        private const val BASE_URL =
            "http://ec2-13-51-255-30.eu-north-1.compute.amazonaws.com:8082/api/"
        private var client: OkHttpClient? = null
        var gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        init {
            client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)//connect time out
                .writeTimeout(1, TimeUnit.MINUTES)//write time out
                .readTimeout(1, TimeUnit.MINUTES)//read time out
                .build()
        }

        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).client(client).build()
        }

        val apiService: ApiService = getRetrofitInstance().create(ApiService::class.java)
    }
}