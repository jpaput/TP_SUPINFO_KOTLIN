package com.supinfo.day2tp2.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.supinfo.day2tp2.LOG_TAG
import com.supinfo.day2tp2.data.Cocktail
import com.supinfo.day2tp2.repositories.CocktailRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mobile.francoisgaucher.fr.coktails.helper.CocktailsHelper

class CocktailViewModel(app : Application) : AndroidViewModel(app) {

    val cocktailRepository = CocktailRepository(app)
    val cocktailData = cocktailRepository.cocktailData
    val context = app

    init {
        Log.i(LOG_TAG, "Cocktail ViewModel have been created")
    }

    fun refreshData(){
        CoroutineScope(Dispatchers.IO).launch {
            cocktailRepository.getData()
        }
    }

}