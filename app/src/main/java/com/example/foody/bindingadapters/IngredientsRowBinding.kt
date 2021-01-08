package com.example.foody.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.foody.R
import com.example.foody.data.constants.Constants.Companion.BASE_IMAGE_URL

class IngredientsRowBinding {

    companion object {
        @BindingAdapter("setAmount")
        @JvmStatic
        fun setAmount(view: TextView, amount: Double) {
            val text = "$amount grams"
            view.text = text
        }

        @BindingAdapter("setNameIngredient")
        @JvmStatic
        fun setNameIngredient(view: TextView, name: String) {
            view.text = name.capitalize()
        }

        @BindingAdapter("loadIngredientImage")
        @JvmStatic
        fun loadIngredientImage(view: ImageView, url: String?) {
            val newUrl = BASE_IMAGE_URL + url
            view.load(newUrl) {
                crossfade(600)
                error(R.drawable.ic_error_drawable)
            }
        }
    }

}