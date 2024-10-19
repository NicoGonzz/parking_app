package com.example.carsdatabase
import androidx.room.Embedded
import androidx.room.Relation

class Clientes_Vehiculos {

    data class ClienteConVehiculos(
        @Embedded val cliente: Clientes,
        @Relation(
            parentColumn = "client_id",
            entityColumn = "cliente_id"
        )
        val vehiculos: List<Vehiculos>
    )

}