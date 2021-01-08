package com.example.foody.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.data.constants.Constants.Companion.RECIPES_TABLE
import com.example.foody.data.models.FoodRecipe

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}