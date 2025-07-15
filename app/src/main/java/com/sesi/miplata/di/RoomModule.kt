package com.sesi.miplata.di

import android.content.Context
import androidx.room.Room
import com.sesi.miplata.data.local.room.AppDataBase
import com.sesi.miplata.data.local.room.dao.CategoryDao
import com.sesi.miplata.data.local.room.dao.IncomeDao
import com.sesi.miplata.data.local.room.dao.OperationsDao
import com.sesi.miplata.data.local.room.dao.RecurringExpensesDao
import com.sesi.miplata.data.local.room.repository.CategoryRepository
import com.sesi.miplata.data.local.room.repository.ExpenseRepository
import com.sesi.miplata.data.local.room.repository.IncomeRepository
import com.sesi.miplata.data.local.room.repository.OperationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "miplata"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(appDatabase: AppDataBase) = appDatabase.categoryDao()

    @Provides
    @Singleton
    fun provideRecurringExpensesDao(appDatabase: AppDataBase) = appDatabase.recurringExpensesDao()

    @Provides
    @Singleton
    fun provideIncomeDao(appDatabase: AppDataBase) = appDatabase.incomeDao()

    @Provides
    @Singleton
    fun provideOperationsDao(appDatabase: AppDataBase) = appDatabase.operationsDao()

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryDao: CategoryDao) = CategoryRepository(categoryDao)

    @Provides
    @Singleton
    fun provideIncomeRepository(incomeDao: IncomeDao) = IncomeRepository(incomeDao)

    @Provides
    @Singleton
    fun provideOperationsRepository(operationsDao: OperationsDao) = OperationRepository(operationsDao)

    @Provides
    @Singleton
    fun provideExpenseRepository(expenseDao: RecurringExpensesDao) = ExpenseRepository(expenseDao)

}