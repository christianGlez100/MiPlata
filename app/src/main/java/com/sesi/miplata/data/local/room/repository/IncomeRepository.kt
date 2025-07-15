package com.sesi.miplata.data.local.room.repository

import com.sesi.miplata.data.local.room.dao.IncomeDao
import com.sesi.miplata.data.local.room.entity.Income
import javax.inject.Inject

class IncomeRepository @Inject constructor(private val incomeDao: IncomeDao) {
    suspend fun getAllIncomes(): List<Income> {
        return incomeDao.getAll()
    }
    suspend fun insertIncome(income: Income) {
        incomeDao.insert(income)
    }
    suspend fun updateIncome(income: Income) {
        incomeDao.update(income)
    }
    suspend fun deleteIncome(income: Income) {
        incomeDao.delete(income)
    }
    suspend fun getIncomeById(id: Long): Income {
        return incomeDao.getById(id)
    }
    suspend fun getAllIncomesMain(): List<Income> {
        return incomeDao.getAllMain()
    }
}