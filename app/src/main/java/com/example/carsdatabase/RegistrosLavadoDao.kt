package com.example.carsdatabase

import androidx.room.*

@Dao
interface RegistrosLavadoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRegistro(registroLavado: RegistrosLavado)

    @Update
    suspend fun updateRegistro(registroLavado: RegistrosLavado)

    @Delete
    suspend fun deleteRegistro(registroLavado: RegistrosLavado)

    @Query("SELECT * FROM registros_lavado_table WHERE vehiculo_id = :vehiculoId")
    suspend fun getRegistrosByVehiculo(vehiculoId: Int): List<RegistrosLavado>

    @Query("SELECT * FROM registros_lavado_table WHERE servicio_id = :servicioId")
    suspend fun getRegistrosByServicio(servicioId: Int): List<RegistrosLavado>

    @Query("SELECT * FROM registros_lavado_table WHERE registro_id = :registroId LIMIT 1")
    suspend fun getRegistroById(registroId: Int): RegistrosLavado?

    @Query("SELECT * FROM registros_lavado_table")
    suspend fun getAllRegistros(): List<RegistrosLavado>
}
