package com.sesi.miplata.data.local.room.dto

data class CategoryDto(
    var categoryId: Long = 0,
    var categoryName: String = "",
    var icon:Int = 0,
    var isSelected:Boolean = false
)
