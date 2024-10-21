package com.example.carsdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.carsdatabase.ui.theme.CarsDatabaseTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: CarsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar la base de datos
        database = Room.databaseBuilder(
            applicationContext,
            CarsDatabase::class.java,
            "cars_database"
        ).build()

        enableEdgeToEdge()
        setContent {
            CarsDatabaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InputForm(
                        modifier = Modifier.padding(innerPadding),
                        onSave = { vehiculo, clientes ->
                            // Insertar datos en la b ase de datos en un hilo de ejecución separado
                            lifecycleScope.launch {
                                database.vehiculosDao().insertVehiculo(vehiculo)
                                println("Datos guardados: ${vehiculo.marca}, ${clientes.nombre}")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun InputForm(
    modifier: Modifier = Modifier,
    onSave: (Vehiculos, Clientes) -> Unit // función de callback para guardar datos
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }

    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }

    var showConfirmation by remember { mutableStateOf(false) } // Estado para mostrar confirmación

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Ingrese los datos del cliente", style = MaterialTheme.typography.titleLarge)

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            isError = nombre.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth(),
            isError = apellido.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ingrese los datos del vehículo", style = MaterialTheme.typography.titleLarge)

        TextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth(),
            isError = marca.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth(),
            isError = modelo.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = placa,
            onValueChange = { placa = it },
            label = { Text("Placa") },
            modifier = Modifier.fillMaxWidth(),
            isError = placa.isEmpty()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = color,
            onValueChange = { color = it },
            label = { Text("Color") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("Tipo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombre.isNotEmpty() && apellido.isNotEmpty() && marca.isNotEmpty() && modelo.isNotEmpty() && placa.isNotEmpty()) {
                    val vehiculo = Vehiculos(
                        clienteId = 1,
                        marca = marca,
                        modelo = modelo,
                        placa = placa,
                        color = color,
                        tipo = tipo
                    )
                    val cliente = Clientes(
                        nombre = nombre,
                        apellido = apellido,
                        telefono = telefono,
                        email = email,
                        direccion = direccion
                    )
                    onSave(vehiculo, cliente)
                    showConfirmation = true // Mostrar mensaje de confirmación
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Guardar Cliente y Vehículo")
        }

        if (showConfirmation) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Datos guardados exitosamente!",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputFormPreview() {
    CarsDatabaseTheme {
        InputForm { _, _ -> }
    }
}
