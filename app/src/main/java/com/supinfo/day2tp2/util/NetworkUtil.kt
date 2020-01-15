package com.supinfo.day2tp2.util

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.supinfo.day2tp2.WEB_SERVICE_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkUtil {

    companion object{

        fun isNetworkAvailable(app : Application) : Boolean{
            val connectivityManager
                    = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val networkInfo = connectivityManager.activeNetwork

            return true

        }


        fun getRetrofit() : Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client =
                OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit
        }
    }


}