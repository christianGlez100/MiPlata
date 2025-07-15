package com.sesi.miplata.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sesi.miplata.data.local.room.entity.Operations

@Dao
interface OperationsDao {
    @Insert
    fun insert(operations: Operations)

    @Update
    fun update(operations: Operations)

    @Delete
    fun delete(operations: Operations)

    @Query("SELECT * FROM OPERACIONES WHERE op_fecha BETWEEN :initDate AND :endDate ORDER BY op_fecha ASC")
    fun getOperationsByDate(initDate: Long, endDate: Long): List<Operations>

    @Query("SELECT * FROM OPERACIONES")
    fun getAll(): List<Operations>
}