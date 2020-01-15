package com.supinfo.day2tp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.supinfo.day2tp2.data.Cocktail
import kotlinx.android.synthetic.main.activity_detail_cocktail.*

class DetailCocktailActivity : AppCompatActivity() {


    companion object{

        fun newInstance(cocktail : Cocktail, context : Context) : Intent {

            val intent = Intent(context, DetailCocktailActivity::class.java)
            intent.putExtra(COCKTAIL_DATA, cocktail)

            return intent;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cocktail)

        val cocktail : Cocktail = intent.getSerializableExtra(COCKTAIL_DATA) as Cocktail

        Glide.with(this)
            .load(cocktail.strDrinkThumb)
            .into(cocktailImageView)

        cocktailName.text = cocktail.strDrink
    }


}
