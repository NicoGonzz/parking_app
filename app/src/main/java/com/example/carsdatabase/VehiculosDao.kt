package com.example.carsdatabase

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

interface VehiculosDao {
    @Transaction
    @Query("SELECT * FROM client_table WHERE client_id = :clientId")
    suspend fun getClienteConVehiculos(clientId: Int): Clientes_Vehiculos.ClienteConVehiculos
}