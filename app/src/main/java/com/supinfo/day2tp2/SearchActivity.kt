package com.supinfo.day2tp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.supinfo.day2tp2.data.Cocktail
import com.supinfo.day2tp2.viewModel.CocktailViewModel
import kotlinx.android.synthetic.main.search_main.*


class SearchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.search_main)

        searchButton.setOnClickListener{
            //TODO
        }

        discoverButton.setOnClickListener{
            startActivity(
                ListCocktailActivity.newInstance(this))
        }
    }

}
