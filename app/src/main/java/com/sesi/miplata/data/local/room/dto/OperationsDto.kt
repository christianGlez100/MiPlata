package com.sesi.miplata.data.local.room.dto

import java.util.Date

data class OperationsDto(
    val id: Long,
    val name: String,
    val note: String,
    val dateText: String,
    val date: Date,
    val amount: Double,
    val categoryName: String,
    val categoryId: Long,
    val icon: Int
)
