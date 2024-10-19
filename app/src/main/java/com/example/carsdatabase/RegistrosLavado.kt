package com.example.carsdatabase

import androidx.room.*
import java.util.*

@Entity(
    tableName = "registros_lavado_table",
    foreignKeys = [
        ForeignKey(
            entity = Vehiculos::class,
            parentColumns = ["vehiculo_id"],
            childColumns = ["vehiculo_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Servicios::class,
            parentColumns = ["servicio_id"],
            childColumns = ["servicio_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["vehiculo_id"]), Index(value = ["servicio_id"])]
)
data class RegistrosLavado(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "registro_id")
    val registroId: Int = 0,

    @ColumnInfo(name = "vehiculo_id")
    val vehiculoId: Int,

    @ColumnInfo(name = "servicio_id")
    val servicioId: Int,

    @ColumnInfo(name = "fecha_lavado")
    val fechaLavado: Date,

    @ColumnInfo(name = "hora_inicio")
    val horaInicio: String,

    @ColumnInfo(name = "hora_fin")
    val horaFin: String,

    @ColumnInfo(name = "precio_total")
    val precioTotal: Double
)
