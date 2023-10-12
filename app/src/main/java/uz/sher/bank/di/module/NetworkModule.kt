package uz.sher.bank.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.sher.bank.data.network.api.ApiClient.getRetrofitInstance
import uz.sher.bank.data.network.api.ApiService
import uz.sher.bank.utils.network.NetworkHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)

    @Provides
    @Singleton
    fun provideRetrofit(): ApiService = getRetrofitInstance().create(ApiService::class.java)


}