package com.sesi.miplata.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sesi.miplata.data.local.room.entity.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM CATEGORIAS")
    fun getAll(): List<Category>

    @Query("SELECT * FROM CATEGORIAS WHERE cat_tipo = :type")
    fun getByType(type: String): List<Category>

    @Insert
    fun insertCategory(categoria: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<Category>)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}