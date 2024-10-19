package com.example.carsdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "servicios_table")
data class Servicios(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "servicio_id")
    val servicioId: Int = 0,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "precio")
    val precio: Double
)