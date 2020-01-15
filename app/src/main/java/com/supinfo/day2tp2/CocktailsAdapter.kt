package com.supinfo.day2tp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.supinfo.day2tp2.data.Cocktail
import kotlinx.android.synthetic.main.cocktai_item_view.view.*

class CocktailsAdapter(private val cocktails: List<Cocktail>, val context: Context, val listener : OnCocktailClickListener)
    : RecyclerView.Adapter<CocktailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cocktai_item_view, parent, false))    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    override fun onBindViewHolder(holder: CocktailsAdapter.ViewHolder, position: Int) {
        val cocktail = cocktails.get(position)


        Glide.with(context)
            .load(cocktail.strDrinkThumb)
            .into(holder.cocktailImage)

        holder.cocktailName.text = cocktail.strDrink

        holder.itemView.setOnClickListener{
            listener.onCocktailClick(cocktail)
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cocktailImage = itemView.cocktailImageView
        val cocktailName = itemView.cocktailName
    }

    public interface OnCocktailClickListener{

        fun onCocktailClick(cocktail : Cocktail)
    }
}