package com.supinfo.day2tp2.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.supinfo.day2tp2.WEB_SERVICE_BASE_URL
import com.supinfo.day2tp2.data.Cocktail
import com.supinfo.day2tp2.data.CocktailWrapper
import com.supinfo.day2tp2.services.CocktailServices
import com.supinfo.day2tp2.util.NetworkUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class CocktailRepository (val app :Application) {

    val cocktailData = MutableLiveData<List<Cocktail>>()

    init{
        CoroutineScope(Dispatchers.IO).launch {
            getData()
        }
    }

    @WorkerThread
    suspend fun getData() {

        val cocktailService =  NetworkUtil.getRetrofit().create(CocktailServices::class.java)
        val cocktailWrapper = cocktailService.getCocktail("a").body() ?: CocktailWrapper(emptyList())

        cocktailData.postValue(cocktailWrapper.cocktails)
    }
}