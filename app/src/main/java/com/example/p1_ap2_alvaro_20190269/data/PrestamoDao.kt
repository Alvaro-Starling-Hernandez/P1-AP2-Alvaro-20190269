package com.example.p1_ap2_alvaro_20190269.data

import androidx.room.*
import com.example.p1_ap2_alvaro_20190269.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamo: Prestamo)

    @Delete
    suspend fun eliminar(prestamo: Prestamo)

    @Query("SELECT * FROM Prestamos WHERE pestamoId =:prestamoId")
    fun buscar(prestamoId: Int): Flow<List<Prestamo>>

    @Query("SELECT * FROM Prestamos ORDER BY pestamoId")
    fun getList(): Flow<List<Prestamo>>

}