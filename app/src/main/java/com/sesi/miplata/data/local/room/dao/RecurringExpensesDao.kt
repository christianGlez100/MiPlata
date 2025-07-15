package com.sesi.miplata.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.sesi.miplata.data.local.room.entity.RecurringExpenses

@Dao
interface RecurringExpensesDao {
    @Insert
    fun insert(gasto: RecurringExpenses)

    @Update
    fun update(gasto: RecurringExpenses)

    @Delete
    fun delete(gasto: RecurringExpenses)

}