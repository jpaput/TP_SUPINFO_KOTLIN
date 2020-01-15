package com.supinfo.day2tp2.services

import com.supinfo.day2tp2.data.Cocktail
import com.supinfo.day2tp2.data.CocktailWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CocktailServices {

    @GET("search.php")
    suspend fun getCocktail(@Query("f") car : String) : Response<CocktailWrapper>

    @POST("cocktail")
    suspend fun postCocktail(@Body cocktail: Cocktail)
}