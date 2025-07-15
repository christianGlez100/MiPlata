package com.sesi.miplata.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORIAS")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cat_id")
    var id: Long,

    @ColumnInfo(name = "cat_nombre")
    var name: String,

    @ColumnInfo(name = "cat_icono", defaultValue = "0")
    var icon: Int,

    @ColumnInfo(name = "cat_tipo")
    var categoryType: String
)
