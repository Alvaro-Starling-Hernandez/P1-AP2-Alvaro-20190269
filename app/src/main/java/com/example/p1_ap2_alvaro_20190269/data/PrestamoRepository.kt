package com.example.p1_ap2_alvaro_20190269.data

import androidx.room.Insert
import com.example.p1_ap2_alvaro_20190269.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {

    suspend fun insertar(prestamo: Prestamo){
        prestamoDao.insertar(prestamo)
    }

    suspend fun eliminar(prestamo: Prestamo){
        prestamoDao.eliminar(prestamo)
    }

    fun buscar(prestamoId: Int): Flow<List<Prestamo>>{
        return prestamoDao.buscar(prestamoId)
    }

    fun getList(): Flow<List<Prestamo>>{
        return prestamoDao.getList()
    }

}