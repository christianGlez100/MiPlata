package com.sesi.miplata.data.local.room.dto

import com.sesi.miplata.data.local.room.entity.Income
import com.sesi.miplata.data.local.room.entity.RecurringExpenses

data class MonthlyDetailDto(
    var bills:List<OperationsDto>,
    var incomes:List<OperationsDto>,
    var recurrentIncomes: List<Income>,
    var recurrentBills: List<RecurringExpenses>
)
