package com.supinfo.day2tp2.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.supinfo.day2tp2.dao.CocktailDAO
import com.supinfo.day2tp2.data.Cocktail
import java.security.AccessControlContext

@Database(entities = [Cocktail::class], version = 1, exportSchema = false)
abstract class TpDataBase : RoomDatabase(){

    abstract public fun cocktailDao(): CocktailDAO

    companion object{
        @Volatile
        private var INSTANCE : TpDataBase? = null

        fun getDatabase(context: Context) : TpDataBase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TpDataBase::class.java,
                        "cocktail.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}