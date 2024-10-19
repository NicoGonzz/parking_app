package com.example.carsdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import java.util.*

@Database(entities = [Vehiculos::class, Servicios::class, RegistrosLavado::class], version = 1)
abstract class CarsDatabase :  RoomDatabase() {
    abstract fun vehiculosDao(): VehiculosDao
    abstract fun serviciosDao(): ServiciosDao
    abstract fun registrosLavadoDao(): RegistrosLavadoDao
}
