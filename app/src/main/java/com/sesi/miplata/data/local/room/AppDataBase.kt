package com.sesi.miplata.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sesi.miplata.data.local.room.converter.Converters
import com.sesi.miplata.data.local.room.dao.CategoryDao
import com.sesi.miplata.data.local.room.dao.IncomeDao
import com.sesi.miplata.data.local.room.dao.OperationsDao
import com.sesi.miplata.data.local.room.dao.RecurringExpensesDao
import com.sesi.miplata.data.local.room.entity.Category
import com.sesi.miplata.data.local.room.entity.Income
import com.sesi.miplata.data.local.room.entity.Operations
import com.sesi.miplata.data.local.room.entity.RecurringExpenses

@TypeConverters(Converters::class)
@Database(
    entities = [Category::class, RecurringExpenses::class, Income::class, Operations::class],
    version = 2
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun recurringExpensesDao(): RecurringExpensesDao
    abstract fun incomeDao(): IncomeDao
    abstract fun operationsDao(): OperationsDao

}