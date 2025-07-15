package com.sesi.miplata.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "OPERACIONES",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("cat_id"),
        childColumns = arrayOf("op_id_categoria")
    )],
    indices = [Index("op_id")]
)
data class Operations(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "op_id")
    var id: Long,

    @ColumnInfo(name = "op_nombre")
    var name: String,

    @ColumnInfo(name = "op_nota")
    var note: String,

    @ColumnInfo(name = "op_fecha")
    var date: Date,

    @ColumnInfo(name = "op_monto", defaultValue = "0")
    var amount: Double,

    @ColumnInfo(name = "op_tipo_operacion")
    var operationType: String,

    @ColumnInfo(name = "op_id_categoria")
    var categoryId: Long,
)
