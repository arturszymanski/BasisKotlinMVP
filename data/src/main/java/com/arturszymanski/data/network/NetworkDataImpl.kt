package com.arturszymanski.data.network

import com.arturszymanski.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

//TODO will be replaced by DI once added
class NetworkDataImpl {

    val networkData : NetworkData

    companion object {
        private var instance : NetworkDataImpl? = null

        @JvmStatic
        fun getInstance() : NetworkDataImpl {
            return instance?.let {
                return it
            } ?: run {
                instance = NetworkDataImpl()
                return instance!!
            }
        }
    }

    private constructor() {
        val okHttpClient : OkHttpClient = OkHttpClient.Builder()
            .build()

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_PATH)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        networkData = retrofit.create(NetworkData::class.java)
    }
}