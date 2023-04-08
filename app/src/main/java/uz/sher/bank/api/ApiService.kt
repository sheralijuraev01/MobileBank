package uz.sher.bank.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    companion object {
        private const val BASE_URL =
            "http://ec2-13-51-255-30.eu-north-1.compute.amazonaws.com:8082/api/"

        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}