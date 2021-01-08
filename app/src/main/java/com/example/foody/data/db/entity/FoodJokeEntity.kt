package com.example.foody.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.data.constants.Constants.Companion.FOOD_JOKE_TABLE
import com.example.foody.data.models.FoodJoke

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(@Embedded var foodJoke: FoodJoke) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}