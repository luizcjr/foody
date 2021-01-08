package com.example.foody.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.data.constants.Constants.Companion.FAVORITES_RECIPES_TABLE
import com.example.foody.data.models.Result

@Entity(tableName = FAVORITES_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)