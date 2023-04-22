package uz.sher.bank.utils

import uz.sher.bank.utils.network.NetworkStatus

data class Resource<out T>(val status:NetworkStatus,val data:T?,val message:String?){

    companion object{
        fun <T>success(data:T?):Resource<T>{
            return Resource(NetworkStatus.SUCCESS,data,null)
        }
        fun <T> error(message: String?):Resource<T>{
            return Resource(NetworkStatus.ERROR,null,message)
        }

        fun <T> loading():Resource<T>{
            return Resource(NetworkStatus.LOADING,null,null)
        }
    }


}