package com.sesi.miplata.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "INGRESOS_RECURRENTES",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("cat_id"),
        childColumns = arrayOf("ir_id_categoria")
    )],
    indices = [Index("ir_id_categoria")]
)
data class Income(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ir_id")
    var id: Long,

    @ColumnInfo(name = "ir_nombre")
    var name: String,

    @ColumnInfo(name = "ir_nota")
    var note: String,

    @ColumnInfo(name = "ir_monto", defaultValue = "0")
    var amount: Double,

    @ColumnInfo(name = "ir_id_categoria")
    var categoryId: Long
)
