package com.example.p1_ap2_alvaro_20190269.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.p1_ap2_alvaro_20190269.model.Prestamo

@Database(
    entities = [Prestamo::class],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val prestamoDao: PrestamoDao
}