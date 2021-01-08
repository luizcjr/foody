package com.example.foody.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foody.data.db.dao.RecipesDao
import com.example.foody.data.db.entity.FavoritesEntity
import com.example.foody.data.db.entity.FoodJokeEntity
import com.example.foody.data.db.entity.RecipesEntity
import com.example.foody.util.RecipesTypeConverter

@Database(entities = [RecipesEntity::class, FavoritesEntity::class, FoodJokeEntity::class], version = 1, exportSchema = false)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}