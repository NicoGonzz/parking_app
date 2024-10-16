package com.example.carsdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehiculos_table")

data class Vehiculos(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vehiculo_id")
    val vehiculoId: Int = 0,

    @ColumnInfo(name = "marca")
    val marca: String,

    @ColumnInfo(name = "modelo")
    val modelo: String,

    @ColumnInfo(name = "placa")
    val placa: String,

    @ColumnInfo(name = "color")
    val color: String,

    @ColumnInfo(name = "tipo")
    val tipo: String,

    @ColumnInfo(name = "cliente_id")
    val clienteId: Int

)