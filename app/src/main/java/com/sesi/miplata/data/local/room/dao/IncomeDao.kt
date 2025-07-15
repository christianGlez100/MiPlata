package com.sesi.miplata.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sesi.miplata.data.local.room.entity.Income

@Dao
interface IncomeDao {
    @Insert
    fun insert(income: Income)

    @Update
    fun update(income: Income)

    @Delete
    fun delete(income: Income)

    @Query("SELECT * FROM INGRESOS_RECURRENTES ORDER BY ir_monto DESC")
    fun getAll(): List<Income>

    @Query("SELECT * FROM INGRESOS_RECURRENTES ORDER BY ir_monto DESC")
    fun getAllMain(): List<Income>

    @Query("SELECT * FROM INGRESOS_RECURRENTES WHERE ir_id = :id")
    fun getById(id: Long?): Income
}