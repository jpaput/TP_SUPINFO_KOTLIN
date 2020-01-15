package com.supinfo.day2tp2.data

import com.squareup.moshi.Json
import java.io.Serializable

data class CocktailWrapper  (
    @field:Json(name = "drinks") val cocktails : List<Cocktail>
): Serializable
