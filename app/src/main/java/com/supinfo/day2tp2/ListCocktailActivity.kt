package com.supinfo.day2tp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.supinfo.day2tp2.CocktailsAdapter.*
import com.supinfo.day2tp2.data.Cocktail
import com.supinfo.day2tp2.viewModel.CocktailViewModel
import kotlinx.android.synthetic.main.activity_list_cocktail.*
import java.io.Serializable

class ListCocktailActivity : AppCompatActivity(), OnCocktailClickListener  {

    private lateinit var cocktailViewModel : CocktailViewModel

    companion object{

        fun newInstance(context : Context) : Intent {

            val intent = Intent(context, ListCocktailActivity::class.java)
            return intent;
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cocktail)

        cocktailViewModel = ViewModelProviders.of(this)
            .get(CocktailViewModel::class.java)

        cocktailViewModel.cocktailData.observe(this, Observer {
            recyclerView.adapter = CocktailsAdapter(it, this, this)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCocktailClick(cocktail: Cocktail) {

        startActivity(
            DetailCocktailActivity.newInstance(cocktail, this))
    }
}
