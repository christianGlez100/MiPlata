package com.sesi.miplata.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "GASTOS_RECURRENTES_2",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("cat_id"),
        childColumns = arrayOf("gr_id_categoria")
    )],
    indices = [Index("gr_id_categoria")]
)
data class RecurringExpenses(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gr_id")
    var id: Long,

    @ColumnInfo(name = "gr_nombre")
    var name: String,

    @ColumnInfo(name = "gr_nota")
    var note: String,

    @ColumnInfo(name = "gr_id_categoria")
    var categoryId: Long,

    @ColumnInfo(name = "gr_monto", defaultValue = "0.0")
    var amount: Double,

    @ColumnInfo(name = "gr_dia_pago", defaultValue = "0")
    var dayToPay: Int
)
