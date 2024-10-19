package com.example.carsdatabase

import androidx.room.*

@Dao
interface ServiciosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServicio(servicio: Servicios)

    @Update
    suspend fun updateServicio(servicio: Servicios)

    @Delete
    suspend fun deleteServicio(servicio: Servicios)

    @Query("SELECT * FROM servicios_table WHERE servicio_id = :servicioId")
    suspend fun getServicioById(servicioId: Int): Servicios?

    @Query("SELECT * FROM servicios_table")
    suspend fun getAllServicios(): List<Servicios>
}
