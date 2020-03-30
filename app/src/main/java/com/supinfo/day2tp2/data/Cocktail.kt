package com.supinfo.day2tp2.data

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

//data class Cocktail(val name : String, val  drawable : Int) : Serializable {

@Entity(tableName = "cocktails")
data class Cocktail (
    @PrimaryKey(autoGenerate = true)
    val cocktailId : Int,
    @field:Json(name = "strDrink")
    val strDrink : String,
    @field:Json(name = "strDrinkThumb")
    val strDrinkThumb : String,
    @field:Json(name = "strIngredient1")
    val strIngredient1 : String?,
    @field:Json(name = "strIngredient2")
    val strIngredient2 : String?,
    @field:Json(name = "strIngredient3")
    val strIngredient3 : String?
): Serializable


