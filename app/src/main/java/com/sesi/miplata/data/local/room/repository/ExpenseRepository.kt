package com.sesi.miplata.data.local.room.repository

import com.sesi.miplata.data.local.room.dao.RecurringExpensesDao
import com.sesi.miplata.data.local.room.entity.RecurringExpenses
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDao: RecurringExpensesDao) {
    suspend fun insertExpense(expense: RecurringExpenses) {
        expenseDao.insert(expense)
    }

    suspend fun updateExpense(expense: RecurringExpenses) {
        expenseDao.update(expense)
    }

    suspend fun deleteExpense(expense: RecurringExpenses) {
        expenseDao.delete(expense)
    }
}