package com.example.foody.util

import androidx.room.TypeConverter
import com.example.foody.data.models.FoodRecipe
import com.example.foody.data.models.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return Gson().toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun resultToString(result: Result): String {
        return Gson().toJson(result)
    }

    @TypeConverter
    fun stringToResult(data: String): Result {
        val listType = object : TypeToken<Result>() {}.type
        return Gson().fromJson(data, listType)
    }
}