package com.example.p1_ap2_alvaro_20190269.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamo")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val pestamoId: Int = 0,
    val deudor: String,
    val concepto: String,
    val monto: Float
)