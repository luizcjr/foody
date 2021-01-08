package com.example.foody.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.data.models.ExtendedIngredient
import com.example.foody.data.models.FoodRecipe
import com.example.foody.databinding.IngredientsRowLayoutBinding
import com.example.foody.util.RecipesDiffUtil

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private var ingredients = emptyList<ExtendedIngredient>()

    class ViewHolder(private val binding: IngredientsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: ExtendedIngredient) {
            binding.ingredient = ingredient
            //Atualiza quando tem alguma alteração nos dados
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = IngredientsRowLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentResult = ingredients[position]

        holder.bind(currentResult)
    }

    override fun getItemCount() = ingredients.size

    fun setData(newData: List<ExtendedIngredient>) {
        val ingredientsDiffUtil = RecipesDiffUtil(ingredients, newData)
        val ingredientDiffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        ingredients = newData
        ingredientDiffUtilResult.dispatchUpdatesTo(this)
    }
}