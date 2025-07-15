package com.sesi.miplata.data.local.room.repository

import com.sesi.miplata.data.local.room.dao.CategoryDao
import com.sesi.miplata.data.local.room.entity.Category
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryDao: CategoryDao) {
    suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAll()
    }
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }
    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }
    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }
    suspend fun getCategoriesByType(type: String): List<Category> {
        return categoryDao.getByType(type)
    }
}