package com.example.carsdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

interface VehiculosDao {
    @Transaction
    @Query("SELECT * FROM client_table WHERE client_id = :clientId")
    suspend fun getClienteConVehiculos(clientId: Int): Clientes_Vehiculos.ClienteConVehiculos

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehiculo(vehiculo: Vehiculos)

    @Update
    suspend fun updateVehiculo(vehiculo: Vehiculos)

    @Delete
    suspend fun deleteVehiculo(vehiculo: Vehiculos)

    @Query("SELECT * FROM vehiculos_table WHERE vehiculo_id = :vehiculoId")
    suspend fun getVehiculoById(vehiculoId: Int): Vehiculos?

    @Query("SELECT * FROM vehiculos_table")
    suspend fun getAllVehiculos(): List<Vehiculos>

}