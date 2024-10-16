package com.example.carsdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "client_table")
data class Clientes(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "client_id")
    val clientId: Int = 0,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "apellido")
    val apellido: String,

    @ColumnInfo(name = "telefono")
    val telefono: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "direccion")
    val direccion: String
)
