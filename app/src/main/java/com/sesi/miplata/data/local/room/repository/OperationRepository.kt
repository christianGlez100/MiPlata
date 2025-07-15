package com.sesi.miplata.data.local.room.repository

import com.sesi.miplata.data.local.room.dao.OperationsDao
import com.sesi.miplata.data.local.room.entity.Operations
import javax.inject.Inject

class OperationRepository @Inject constructor(private val operationsDao: OperationsDao) {
    suspend fun getAllOperations(): List<Operations> {
        return operationsDao.getAll()
    }
    suspend fun insertOperation(operation: Operations) {
        operationsDao.insert(operation)
    }
    suspend fun updateOperation(operation: Operations) {
        operationsDao.update(operation)
    }
    suspend fun deleteOperation(operation: Operations) {
        operationsDao.delete(operation)
    }
    suspend fun getOperationsByDate(initDate: Long, endDate: Long): List<Operations> {
        return operationsDao.getOperationsByDate(initDate, endDate)
    }
}